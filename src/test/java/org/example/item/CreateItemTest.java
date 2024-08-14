package org.example.item;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.mapper.ResponseMapper;
import org.example.model.service.Item;
import org.example.verification.assertion.common.HttpAssertion;
import org.example.verification.assertion.module.item.ItemAssertion;
import org.example.verification.assumption.common.HttpAssumption;
import org.example.verification.assumption.module.item.ItemAssumption;
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

        Response postResponse = itemClient.createItem(requestBody);
        HttpAssertion.assertThat(postResponse)
                .statusIsOk();
        ItemAssertion.assertThat(postResponse)
                .comesFromRequestBody(requestBody);

        Item postResponseBody = ResponseMapper.mapToItem(postResponse);

        Response getResponse = itemClient.getItemById(postResponseBody.id());
        HttpAssumption.assumeThat(getResponse)
                .statusIsOk();
        ItemAssumption.assumeThat(getResponse)
                .comesFromRequestBody(requestBody);
    }

}
