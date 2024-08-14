package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.model.service.Item;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.ItemAssertionAssumption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Get Item")
@DisplayName("Get Item Test")
public class GetItemTest extends BaseTest {

  @DisplayName("Get Item: ")
  @ParameterizedTest(name = "for item with id = 7")
  @MethodSource("org.example.factory.ItemFactory#provideItemWithId7")
  public void getItem(Item expectedItem) {
    String id = "7";

    Response response = itemClient.getItemById(id);
    HttpAssertionAssumption.assertThat(response)
        .statusIsOk();
    ItemAssertionAssumption.assertThat(response)
        .isEqualTo(expectedItem);
  }

}
