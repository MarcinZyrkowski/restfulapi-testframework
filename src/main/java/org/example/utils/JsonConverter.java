package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import lombok.SneakyThrows;

public class JsonConverter {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @SneakyThrows
  public static String serializePojo(Object pojo) {
    Objects.requireNonNull(pojo, "Null POJO provided");
    return OBJECT_MAPPER.writeValueAsString(pojo);
  }

}
