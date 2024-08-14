package org.example.mapper;

import io.restassured.response.Response;
import java.util.List;
import org.example.model.service.Item;
import org.example.model.service.ItemListWrapper;

public class ResponseMapper {

  public static Item mapToItem(Response response) {
    return response.as(Item.class);
  }

  public static ItemListWrapper mapToItemListWrapper(Response response) {
    Item[] itemArray = response.as(Item[].class);
    List<Item> list = List.of(itemArray);
    return new ItemListWrapper(list);
  }

}
