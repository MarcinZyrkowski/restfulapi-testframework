package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.mapper.ResponseMapper;
import org.example.model.service.Item;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.ItemAssertionAssumption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Create Item")
@DisplayName("Create Item Test")
public class CreateItemTest extends BaseTest {

  @DisplayName("Create item")
  @ParameterizedTest(name = "with random values")
  @MethodSource("org.example.factory.ItemFactory#provideRandomItem")
  public void createItem(Item requestBody) {

    // create item
    Response postResponse = itemClient.createItem(requestBody);
    HttpAssertionAssumption.assertThat(postResponse)
        .statusIsOk();
    ItemAssertionAssumption.assertThat(postResponse)
        .comesFromRequestBody(requestBody);

    // verify item is created
    Item postResponseBody = ResponseMapper.mapToItem(postResponse);
    Response getResponse = itemClient.getItemById(postResponseBody.id());
    HttpAssertionAssumption.assumeThat(getResponse)
        .statusIsOk();
    ItemAssertionAssumption.assumeThat(getResponse)
        .comesFromRequestBody(requestBody);

    // tear down
    // delete created item
    Response deleteResponse = itemClient.deleteItem(postResponseBody.id());
    HttpAssertionAssumption.assumeThat(deleteResponse)
        .statusIsOk();
  }

}
