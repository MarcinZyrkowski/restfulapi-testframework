package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import java.util.Random;
import org.example.BaseTest;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.DeleteMessageAssertionAssumption;
import org.example.assertion.module.item.ErrorResponseAssertionAssumption;
import org.example.generator.DeleteResponseGenerator;
import org.example.generator.ErrorResponseGenerator;
import org.example.model.service.restfulapi.item.DeleteResponse;
import org.example.model.service.restfulapi.ErrorResponse;
import org.example.model.service.restfulapi.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Delete Item")
@DisplayName("Delete Item Test")
public class DeleteItemTest extends BaseTest {

  @DisplayName("Positive: Delete item")
  @ParameterizedTest(name = "- created with random values")
  @MethodSource("org.example.factory.ItemFactory#provideRandomItem")
  public void deleteItem(Item requestBody) {
    // create item
    Item postResponseBody = itemController.createItem(requestBody);

    // delete item
    DeleteResponse expectedDeleteResponse = DeleteResponseGenerator.generateWithId(postResponseBody.id());
    Response deleteResponse = itemClient.deleteItem(postResponseBody.id());
    HttpAssertionAssumption.assertThat(deleteResponse)
        .statusIsOk();
    DeleteMessageAssertionAssumption.assertThat(deleteResponse)
        .isEqualsTo(expectedDeleteResponse);

    // verify item is deleted
    itemController.verifyItemDoesntExist(postResponseBody.id());
  }

  @DisplayName("Negative: Delete item - ids 1, ... 13 cannot be deleted")
  @Test
  public void deleteItemWithIdFrom1To13() {
    Random random = new Random();
    int minId = 1;
    int maxId = 13;
    String itemId = String.valueOf(random.nextInt(minId, maxId));

    ErrorResponse expectedDeleteResponse = ErrorResponseGenerator.generateReservedObjectCannotBeDeleted(itemId);
    Response deleteResponse = itemClient.deleteItem(itemId);
    HttpAssertionAssumption.assumeThat(deleteResponse)
        .statusIsMethodNotAllowed();
    ErrorResponseAssertionAssumption.assertThat(deleteResponse)
        .isEqualTo(expectedDeleteResponse);
  }

}
