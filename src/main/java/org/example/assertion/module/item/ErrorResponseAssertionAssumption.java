package org.example.assertion.module.item;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.assertj.core.api.ObjectAssert;
import org.example.mapper.ResponseMapper;
import org.example.model.service.ErrorResponse;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponseAssertionAssumption {

  private ObjectAssert<ErrorResponse> errorResponseObjectAssertionAssumption;

  public static ErrorResponseAssertionAssumption assumeThat(Response response) {
    ErrorResponse errorResponse = ResponseMapper.mapToErrorResponse(response);
    return new ErrorResponseAssertionAssumption(Assumptions.assumeThat(errorResponse));
  }

  public static ErrorResponseAssertionAssumption assertThat(Response response) {
    ErrorResponse errorResponse = ResponseMapper.mapToErrorResponse(response);
    return new ErrorResponseAssertionAssumption(Assertions.assertThat(errorResponse));
  }

  public void isEqualTo(ErrorResponse errorResponse) {
    Allure.step("Error response is equal to", () -> {
          errorResponseObjectAssertionAssumption
              .isEqualTo(errorResponse);

          Allure.addAttachment("error response", JsonConverter.serializePojo(errorResponse));
        }
    );
  }

}
