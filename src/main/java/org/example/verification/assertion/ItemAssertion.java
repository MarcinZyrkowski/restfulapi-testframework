package org.example.verification.assertion;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.mapper.ResponseMapper;
import org.example.model.Item;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemAssertion {

    private Item item;

    public static ItemAssertion assertThat(Response response) {
        Item item = ResponseMapper.mapToItem(response);
        return new ItemAssertion(item);
    }

    public void isEqualTo(Item expectedItem) {
        Assertions.assertThat(item)
                .isEqualTo(expectedItem);
    }

}
