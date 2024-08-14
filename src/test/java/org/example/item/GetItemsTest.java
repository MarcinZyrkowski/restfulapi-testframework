package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import java.util.List;
import org.example.BaseTest;
import org.example.model.service.Item;
import org.example.verification.assertion.common.HttpAssertion;
import org.example.verification.assertion.module.item.ItemsAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Item")
@Feature("Get Items")
@DisplayName("Get Items Test")
public class GetItemsTest extends BaseTest {

  @DisplayName("Get Items: ")
  @ParameterizedTest(name = "for items with id = 3,5,7")
  @MethodSource("org.example.factory.ItemsFactory#provideItemsWithIds357")
  public void getItemsByIds(List<Item> expectedItemList) {
    String[] ids = {"3", "5", "7"};

    Response response = itemClient.getItemsByIds(ids);
    HttpAssertion.assertThat(response)
        .statusIsOk();
    ItemsAssertion.assertThat(response)
        .isEqualTo(expectedItemList);
  }

}
