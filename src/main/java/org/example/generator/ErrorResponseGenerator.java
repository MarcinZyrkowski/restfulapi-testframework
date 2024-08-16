package org.example.generator;

import org.example.model.service.restfulapi.ErrorResponse;

public class ErrorResponseGenerator {

  private static ErrorResponse genereteErrorResponse(String message) {
    return ErrorResponse.builder()
        .error(message)
        .build();
  }

  public static ErrorResponse generateObjectWithIdNotFound(String objectId) {
    String objectNotFoundMessage = String.format("Oject with id=%s was not found.", objectId);
    return genereteErrorResponse(objectNotFoundMessage);
  }

  public static ErrorResponse generateReservedObjectCannotBeDeleted(String reservedObjectId) {
    String reservedObjectCannotBeDeletedMessage = String.format(
        "%s is a reserved id and the data object of it cannot be deleted. You can create your own new object via "
            + "POST request and try to send a DELETE request with new generated object id.",
        reservedObjectId);

    return genereteErrorResponse(reservedObjectCannotBeDeletedMessage);
  }

}
