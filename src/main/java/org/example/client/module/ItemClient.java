package org.example.client.module;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.client.RestClient;
import org.example.model.service.Item;

import java.util.Arrays;
import java.util.List;

public class ItemClient extends RestClient {

    private static final String GET_ITEM = "/objects/{itemId}";
    private static final String ITEMS = "/objects";

    @Step("Get item by id: {itemId}")
    public Response getItemById(int itemId) {
        return basicRequestSpecification()
                .pathParam("itemId", itemId)
                .get(GET_ITEM);
    }

    @Step("Get items by ids: {ids}")
    public Response getItemsByIds(int... ids) {
        List<Integer> idList = Arrays.stream(ids)
                .boxed()
                .toList();

        return basicRequestSpecification()
                .queryParams("id", idList)
                .get(ITEMS);
    }

    @Step("Create Item")
    public Response createItem(Item item) {
        return basicRequestSpecification()
                .body(item)
                .post(ITEMS);
    }

}
