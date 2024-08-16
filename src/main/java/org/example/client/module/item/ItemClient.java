package org.example.client.module.item;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import org.example.client.RestClient;
import org.example.model.service.restfulapi.item.Item;

public class ItemClient extends RestClient {

  private static final String ITEM_BY_ID = "/objects/{itemId}";
  private static final String ITEMS = "/objects";

  @Step("Get item by id: {itemId}")
  public Response getItemById(String itemId) {
    return basicRequestSpecification()
        .pathParam("itemId", itemId)
        .get(ITEM_BY_ID);
  }

  @Step("Get items by ids: {ids}")
  public Response getItemsByIds(String... ids) {
    List<String> idList = Arrays.stream(ids)
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

  @Step("Delete item by id: {itemId}")
  public Response deleteItem(String itemId) {
    return basicRequestSpecification()
        .pathParam("itemId", itemId)
        .delete(ITEM_BY_ID);
  }

}
