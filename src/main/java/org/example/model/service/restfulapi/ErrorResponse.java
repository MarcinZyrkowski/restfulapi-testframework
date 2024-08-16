package org.example.model.service.restfulapi;

import lombok.Builder;

@Builder
public record ErrorResponse(String error) {

}
