package org.example.item;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.verification.assertion.HttpAssertion;
import org.junit.jupiter.api.Test;

public class GetItemTest extends BaseTest {

    @Test
    public void getItem() {
        int id = 7;

        Response response = itemClient.getItemById(id);
        HttpAssertion.assertThat(response)
                .statusIsOk();

    }

}
