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
@Feature("Update Item")
@DisplayName("Update Item Test")
public class UpdateItemTest extends BaseTest {

  @DisplayName("Update item")
  @ParameterizedTest(name = "with random values")
  @MethodSource("org.example.factory.ItemsFactory#provideItemAndItsUpdatedVersion")
  public void updateItem(Item origin, Item updatedValues) {
    // create item
    Item createdItem = itemController.createItem(origin);

    Response uptadedItemResponse = itemClient.updateItem(createdItem.id(), updatedValues);
    HttpAssertionAssumption.assertThat(uptadedItemResponse)
        .statusIsOk();
    ItemAssertionAssumption.assertThat(uptadedItemResponse)
        .comesFromRequestBody(updatedValues);

    // verify item is created
    itemController.verifyItemExists(createdItem.id(), updatedValues);

    // tear down
    itemController.deleteItem(createdItem.id());
  }

}
