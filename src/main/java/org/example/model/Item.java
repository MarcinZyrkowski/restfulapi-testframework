package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Item(String id,
                   String name,
                   Data data) {

    @Builder
    public record Data(Integer year,
                       Double price,
                       String color,
                       @JsonProperty("capacity GB") Integer capacity,
                       @JsonProperty("CPU model") String cpuModel,
                       @JsonProperty("Hard disk size") String hardDiskSize) {
    }

}
