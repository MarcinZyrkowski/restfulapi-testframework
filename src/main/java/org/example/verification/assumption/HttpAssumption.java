package org.example.verification.assumption;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assumptions;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpAssumption {

    private Response response;

    public static HttpAssumption assumeThat(Response response) {
        return new HttpAssumption(response);
    }

    public void validateResponseStatusCode(int httpStatusCode) {
        Assumptions.assumeThat(response.getStatusCode())
                .withFailMessage("Status code should be " + httpStatusCode + " but was: " + response.getStatusCode())
                .isEqualTo(httpStatusCode);
    }

    @Step("Status code was: 200")
    public void statusIsOk() {
        validateResponseStatusCode(HttpStatus.SC_OK);
    }

    @Step("Status code was: 201")
    public void statusIsCreated() {
        validateResponseStatusCode(HttpStatus.SC_CREATED);
    }

}
