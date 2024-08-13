package org.example.item;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.model.Item;
import org.example.verification.assertion.ItemAssertion;
import org.junit.jupiter.api.Test;

public class GetItemTest extends BaseTest {

    @Test
    public void getItem() {
        int id = 7;
        Item expectedItem = Item.builder()
                .id("7")
                .name("Apple MacBook Pro 16")
                .data(Item.Data.builder()
                        .year(2019)
                        .price(1849.99)
                        .cpuModel("Intel Core i9")
                        .hardDiskSize("1 TB")
                        .build())
                .build();

        Response response = itemClient.getItemById(id);
        ItemAssertion.assertThat(response)
                .isEqualTo(expectedItem);
    }

}
