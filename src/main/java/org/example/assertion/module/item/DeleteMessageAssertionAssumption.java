package org.example.assertion.module.item;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.example.mapper.ResponseMapper;
import org.example.model.service.restfulapi.item.DeleteResponse;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteMessageAssertionAssumption {

  private ObjectAssert<DeleteResponse> deleteResponseObjectAssertionAssumption;

  public static DeleteMessageAssertionAssumption assertThat(Response response) {
    DeleteResponse deleteResponse = ResponseMapper.mapToDeleteResponse(response);
    return new DeleteMessageAssertionAssumption(Assertions.assertThat(deleteResponse));
  }

  public void isEqualsTo(DeleteResponse deleteResponse) {
    Allure.step("Delete Response is equal to", () -> {
          deleteResponseObjectAssertionAssumption
              .isEqualTo(deleteResponse);

          Allure.addAttachment("Expected delete response", JsonConverter.serializePojo(deleteResponse));
        }
    );
  }

}
