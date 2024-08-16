package org.example.assertion.module.item;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.assertj.core.api.ObjectAssert;
import org.example.mapper.ResponseMapper;
import org.example.model.service.restfulapi.item.Item;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemAssertionAssumption {

  private ObjectAssert<Item> itemObjectAssert;

  public static ItemAssertionAssumption assertThat(Response response) {
    Item item = ResponseMapper.mapToItem(response);
    return new ItemAssertionAssumption(Assertions.assertThat(item));
  }

  public static ItemAssertionAssumption assumeThat(Response response) {
    Item item = ResponseMapper.mapToItem(response);
    return new ItemAssertionAssumption(Assumptions.assumeThat(item));
  }

  public void isEqualTo(Item expectedItem) {
    Allure.step("Assert/Assume item is equal to", () -> {
      itemObjectAssert
          .isEqualTo(expectedItem);

      Allure.addAttachment("expected item", JsonConverter.serializePojo(expectedItem));
    });
  }

  public void comesFromRequestBody(Item requestBody) {
    Allure.step("Assert/Assume item response comes from request body", () -> {
      itemObjectAssert
          .usingRecursiveComparison()
          .ignoringFields("id", "createdAt")
          .isEqualTo(requestBody);

      Allure.addAttachment("request body", JsonConverter.serializePojo(requestBody));
    });
  }

}
