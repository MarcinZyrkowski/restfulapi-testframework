package org.example.model.service.restfulapi.item;

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
                   String createdAt,
                   String updatedAt) {

  @With
  @Builder(toBuilder = true)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public record Data(Integer year,
                     Double price,
                     String Price,
                     String color,
                     String Color,
                     String capacity,
                     String Capacity,
                     String generation,
                     String Generation,
                     @JsonProperty("Strap Colour") String strapColour,
                     @JsonProperty("Case Size") String caseSize,
                     @JsonProperty("Description") String description,
                     @JsonProperty("capacity GB") Integer capacityGB,
                     @JsonProperty("Screen size") Double screenSize,
                     @JsonProperty("CPU model") String cpuModel,
                     @JsonProperty("Hard disk size") String hardDiskSize) {

  }

}
