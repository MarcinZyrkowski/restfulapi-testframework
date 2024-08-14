package org.example.verification.assertion.module.item;


import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.model.service.Item;
import org.example.utils.JsonConverter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemsAssertion {

    private List<Item> itemsResponse;

    public static ItemsAssertion assertThat(Response response) {
        Item[] itemArray = response.as(Item[].class);
        return new ItemsAssertion(List.of(itemArray));
    }

    public void isEqualTo(List<Item> expectedList) {
        Allure.step("Assert items response is equal to", () -> {
            Assertions.assertThat(itemsResponse)
                    .isEqualTo(expectedList);

            Allure.addAttachment("expected list", JsonConverter.serializePojo(expectedList));
        });
    }

}
