package org.example.generator;

import org.example.model.service.restfulapi.item.DeleteResponse;

public class DeleteResponseGenerator {

  public static DeleteResponse generateWithId(String id) {
    return DeleteResponse.builder()
        .message(String.format("Object with id = %s has been deleted.", id))
        .build();
  }

}
