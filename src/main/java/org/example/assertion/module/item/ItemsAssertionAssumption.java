package org.example.assertion.module.item;


import io.qameta.allure.Allure;
import io.restassured.response.Response;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.example.mapper.ResponseMapper;
import org.example.model.service.restfulapi.item.Item;
import org.example.model.service.restfulapi.item.ItemListWrapper;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemsAssertionAssumption {

  private ObjectAssert<ItemListWrapper> itemListWrapperObjectAssertionAssumption;

  public static ItemsAssertionAssumption assertThat(Response response) {
    ItemListWrapper itemListWrapper = ResponseMapper.mapToItemListWrapper(response);
    return new ItemsAssertionAssumption(Assertions.assertThat(itemListWrapper));
  }

  public void isEqualTo(List<Item> expectedList) {
    Allure.step("Assert/Assume items response is equal to", () -> {
      itemListWrapperObjectAssertionAssumption
          .usingRecursiveComparison()
          .ignoringCollectionOrder()
          .isEqualTo(new ItemListWrapper(expectedList));

      Allure.addAttachment("expected list", JsonConverter.serializePojo(expectedList));
    });
  }

}
