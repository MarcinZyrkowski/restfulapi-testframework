package org.example.model.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.With;

@With
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Item(String id,
                   String name,
                   Data data,
                   String createdAt) {

    @With
    @Builder(toBuilder = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Data(Integer year,
                       Double price,
                       String color,
                       @JsonProperty("capacity GB") Integer capacity,
                       @JsonProperty("CPU model") String cpuModel,
                       @JsonProperty("Hard disk size") String hardDiskSize) {
    }

}
