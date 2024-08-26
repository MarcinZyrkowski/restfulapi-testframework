package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.ItemAssertionAssumption;
import org.example.model.service.restfulapi.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Partial Update Test")
@DisplayName("Partial Update Test")
public class PartialUpdateTest extends BaseTest {

  @DisplayName("Partial update test")
  @ParameterizedTest(name = "update name")
  @MethodSource("org.example.factory.ItemFactory#provideRandomItem")
  public void partialUpdateTest(Item requestBody) {
    // create item
    Item createdItem = itemController.createItem(requestBody);

    // update item body
    Item updateRequestBody = Item.builder()
        .name(createdItem.name() + " - update")
        .build();

    // update item
    Response updatedItemResponse = itemClient.partialUpdate(createdItem.id(), updateRequestBody);
    Item expectedUpdatedItem = createdItem.toBuilder()
        .name(updateRequestBody.name())
        .build();
    HttpAssertionAssumption.assertThat(updatedItemResponse)
        .statusIsOk();
    ItemAssertionAssumption.assertThat(updatedItemResponse)
        .comesFromRequestBody(expectedUpdatedItem);

    // tear down
    itemController.deleteItem(createdItem.id());
  }

}
