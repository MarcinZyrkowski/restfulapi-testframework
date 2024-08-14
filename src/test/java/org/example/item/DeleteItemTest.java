package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.DeleteMessageAssertionAssumption;
import org.example.assertion.module.item.ErrorResponseAssertionAssumption;
import org.example.generator.DeleteResponseGenerator;
import org.example.generator.ErrorResponseGenerator;
import org.example.mapper.ResponseMapper;
import org.example.model.service.DeleteResponse;
import org.example.model.service.ErrorResponse;
import org.example.model.service.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Delete Item")
@DisplayName("Delete Item Test")
public class DeleteItemTest extends BaseTest {

  @DisplayName("Delete item")
  @ParameterizedTest(name = "- created with random values")
  @MethodSource("org.example.factory.ItemFactory#provideRandomItem")
  public void deleteItem(Item requestBody) {
    // create item
    Response postResponse = itemClient.createItem(requestBody);
    HttpAssertionAssumption.assumeThat(postResponse)
        .statusIsOk();
    Item postResponseBody = ResponseMapper.mapToItem(postResponse);

    // delete item
    DeleteResponse expectedDeleteResponse = DeleteResponseGenerator.generateWithId(postResponseBody.id());
    Response deleteResponse = itemClient.deleteItem(postResponseBody.id());
    HttpAssertionAssumption.assertThat(deleteResponse)
        .statusIsOk();
    DeleteMessageAssertionAssumption.assertThat(deleteResponse)
        .isEqualsTo(expectedDeleteResponse);

    // verify item is deleted
    ErrorResponse expectedErrorResponse = ErrorResponseGenerator.generateWithId(postResponseBody.id());
    Response getResponse = itemClient.getItemById(postResponseBody.id());
    HttpAssertionAssumption.assumeThat(getResponse)
        .statusIsNotFound();
    ErrorResponseAssertionAssumption.assumeThat(getResponse)
        .isEqualTo(expectedErrorResponse);
  }

  // todo add test for removing constant data e.g. item with id 6

}
