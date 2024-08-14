package org.example.verification.assumption.module.item;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assumptions;
import org.example.mapper.ResponseMapper;
import org.example.model.service.Item;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemAssumption {

    private Item itemResponse;

    public static ItemAssumption assumeThat(Response response) {
        Item item = ResponseMapper.mapToItem(response);
        return new ItemAssumption(item);
    }

    public void comesFromRequestBody(Item requestBody) {
        Allure.step("Assume that item response comes from request body", () -> {
            Assumptions.assumeThat(itemResponse)
                    .usingRecursiveComparison()
                    .ignoringFields("id", "createdAt")
                    .isEqualTo(requestBody);

            Allure.addAttachment("request body", JsonConverter.serializePojo(requestBody));
        });
    }

}
