package org.example.assertion.common;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpAssertionAssumption {

  private Response response;
  private AbstractIntegerAssert<?> abstractIntegerAssert;

  public static HttpAssertionAssumption assertThat(Response response) {
    AbstractIntegerAssert<?> abstractIntegerAssert = Assertions.assertThat(response.getStatusCode());
    return new HttpAssertionAssumption(response, abstractIntegerAssert);
  }

  public static HttpAssertionAssumption assumeThat(Response response) {
    AbstractIntegerAssert<?> abstractIntegerAssert = Assumptions.assumeThat(response.getStatusCode());
    return new HttpAssertionAssumption(response, abstractIntegerAssert);
  }

  public void validateResponseStatusCode(int httpStatusCode) {
    abstractIntegerAssert
        .withFailMessage("Status code should be " + httpStatusCode + " but was: "
            + response.getStatusCode())
        .isEqualTo(httpStatusCode);
  }

  @Step("Status code was: 200")
  public void statusIsOk() {
    validateResponseStatusCode(HttpStatus.SC_OK);
  }

}
