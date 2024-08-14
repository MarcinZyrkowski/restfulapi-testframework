package org.example.verification.assertion.module.item;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.mapper.ResponseMapper;
import org.example.model.service.Item;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemAssertion {

    private Item item;

    public static ItemAssertion assertThat(Response response) {
        Item item = ResponseMapper.mapToItem(response);
        return new ItemAssertion(item);
    }

    public void isEqualTo(Item expectedItem) {
        Allure.step("is equal to", () -> {
            Assertions.assertThat(item)
                    .isEqualTo(expectedItem);

            Allure.addAttachment("expected item", JsonConverter.serializePojo(expectedItem));
        });
    }

    public void comesFromRequestBody(Item requestBody) {
        Allure.step("comes from request body", () -> {
            Assertions.assertThat(item)
                    .usingRecursiveComparison()
                    .ignoringFields("id", "createdAt")
                    .isEqualTo(requestBody);

            Allure.addAttachment("request body", JsonConverter.serializePojo(requestBody));
        });
    }

}
