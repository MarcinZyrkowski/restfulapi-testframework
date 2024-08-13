package org.example.mapper;

import io.restassured.response.Response;
import org.example.model.Item;

public class ResponseMapper {

    public static Item mapToItem(Response response) {
        return response.as(Item.class);
    }

}
