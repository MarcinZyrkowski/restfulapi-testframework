package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.ItemAssertionAssumption;
import org.example.mapper.ResponseMapper;
import org.example.model.service.restfulapi.item.Item;
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

    // created item
    Item postResponseBody = ResponseMapper.mapToItem(postResponse);

    // verify item is created
    itemController.verifyItemExists(postResponseBody.id(), requestBody);

    // tear down
    itemController.deleteItem(postResponseBody.id());
  }

}
