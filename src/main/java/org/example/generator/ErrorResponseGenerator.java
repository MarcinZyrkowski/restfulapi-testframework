package org.example.generator;

import org.example.model.service.ErrorResponse;

public class ErrorResponseGenerator {

  public static ErrorResponse generateWithId(String id) {
    return ErrorResponse.builder()
        .error(String.format("Oject with id=%s was not found.", id))
        .build();
  }

}
