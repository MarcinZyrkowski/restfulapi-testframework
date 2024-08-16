package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import java.util.List;
import org.example.BaseTest;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.ItemsAssertionAssumption;
import org.example.model.service.restfulapi.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Get All Items")
@DisplayName("Get All Items Test")
public class GetAllItemsTest extends BaseTest {

  @DisplayName("get all items")
  @ParameterizedTest(name = "- get all predefined items")
  @MethodSource("org.example.factory.ItemsFactory#provideAllPredefineItems")
  public void getAllItems(List<Item> allItems) {
    Response response = itemClient.getItems();
    HttpAssertionAssumption.assertThat(response)
        .statusIsOk();

    ItemsAssertionAssumption.assertThat(response)
        .isEqualTo(allItems);
  }

}
