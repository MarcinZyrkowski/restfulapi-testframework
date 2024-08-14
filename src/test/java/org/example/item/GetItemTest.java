package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.model.service.Item;
import org.example.verification.assertion.common.HttpAssertion;
import org.example.verification.assertion.module.item.ItemAssertion;
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
        HttpAssertion.assertThat(response)
                .statusIsOk();
        ItemAssertion.assertThat(response)
                .isEqualTo(expectedItem);
    }

}
