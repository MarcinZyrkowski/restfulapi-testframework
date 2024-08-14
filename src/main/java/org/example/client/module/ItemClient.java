package org.example.client.module;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.client.RestClient;

public class ItemClient extends RestClient {

    private static final String GET_ITEM = "/objects/{itemId}";

    @Step("Get item by id: {itemId}")
    public Response getItemById(int itemId) {
        return basicRequestSpecification()
                .pathParam("itemId", itemId)
                .get(GET_ITEM);
    }

}
