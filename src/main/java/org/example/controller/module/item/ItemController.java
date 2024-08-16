package org.example.controller.module.item;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.assertion.common.HttpAssertionAssumption;
import org.example.assertion.module.item.ErrorResponseAssertionAssumption;
import org.example.assertion.module.item.ItemAssertionAssumption;
import org.example.client.module.item.ItemClient;
import org.example.generator.ErrorResponseGenerator;
import org.example.mapper.ResponseMapper;
import org.example.model.service.ErrorResponse;
import org.example.model.service.Item;

public class ItemController {

  private static final ItemClient itemClient = new ItemClient();

  @Step("Create Item")
  public Item createItem(Item requestBody) {
    Response postResponse = itemClient.createItem(requestBody);
    HttpAssertionAssumption.assumeThat(postResponse)
        .statusIsOk();
    return ResponseMapper.mapToItem(postResponse);
  }

  @Step("Verify Item doesn't exist - using get method")
  public void verifyItemDoesntExist(String itemId) {
    ErrorResponse expectedErrorResponse = ErrorResponseGenerator.generateObjectWithIdNotFound(itemId);

    Response getResponse = itemClient.getItemById(itemId);
    HttpAssertionAssumption.assumeThat(getResponse)
        .statusIsNotFound();
    ErrorResponseAssertionAssumption.assumeThat(getResponse)
        .isEqualTo(expectedErrorResponse);
  }

  @Step("Delete item")
  public void deleteItem(String itemId) {
    Response deleteResponse = itemClient.deleteItem(itemId);
    HttpAssertionAssumption.assumeThat(deleteResponse)
        .statusIsOk();
  }

  @Step("Verify Item exists - using get method")
  public void verifyItemExists(String itemId, Item requestBody) {
    Response getResponse = itemClient.getItemById(itemId);
    HttpAssertionAssumption.assumeThat(getResponse)
        .statusIsOk();
    ItemAssertionAssumption.assumeThat(getResponse)
        .comesFromRequestBody(requestBody);
  }

}
