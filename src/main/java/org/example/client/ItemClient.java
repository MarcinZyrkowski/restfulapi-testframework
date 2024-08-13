package org.example.client;

import io.restassured.response.Response;

public class ItemClient extends RestClient {

    private static final String GET_ITEM = "/objects/{itemId}";

    public Response getItemById(int itemId) {
        return basicRequestSpecification()
                .pathParam("itemId", itemId)
                .get(GET_ITEM);
    }

}
