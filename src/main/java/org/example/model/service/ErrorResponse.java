package org.example.model.service;

import lombok.Builder;

@Builder
public record ErrorResponse(String error) {

}
