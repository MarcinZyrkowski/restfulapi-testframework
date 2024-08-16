package org.example.mapper;

import io.restassured.response.Response;
import java.util.List;
import org.example.model.service.restfulapi.item.DeleteResponse;
import org.example.model.service.restfulapi.ErrorResponse;
import org.example.model.service.restfulapi.item.Item;
import org.example.model.service.restfulapi.item.ItemListWrapper;

public class ResponseMapper {

  public static Item mapToItem(Response response) {
    return response.as(Item.class);
  }

  public static ItemListWrapper mapToItemListWrapper(Response response) {
    Item[] itemArray = response.as(Item[].class);
    List<Item> list = List.of(itemArray);
    return new ItemListWrapper(list);
  }

  public static DeleteResponse mapToDeleteResponse(Response response) {
    return response.as(DeleteResponse.class);
  }

  public static ErrorResponse mapToErrorResponse(Response response) {
    return response.as(ErrorResponse.class);
  }

}
