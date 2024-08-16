package org.example.model.utils.service.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CpuModel {

  INTEL_CORE_I3("Intel Core i3"),
  INTEL_CORE_I5("Intel Core i5"),
  INTEL_CORE_I7("Intel Core i7"),
  INTEL_CORE_I9("Intel Core i9"),
  AMD_RYZEN_3("AMD Ryzen 3"),
  AMD_RYZEN_5("AMD Ryzen 5"),
  AMD_RYZEN_7("AMD Ryzen 7"),
  AMD_RYZEN_9("AMD Ryzen 9"),
  APPLE_M1("Apple M1"),
  APPLE_M1_PRO("Apple M1 Pro"),
  APPLE_M1_MAX("Apple M1 Max"),
  QUALCOMM_SNAPDRAGON_888("Qualcomm Snapdragon 888"),
  QUALCOMM_SNAPDRAGON_865("Qualcomm Snapdragon 865");

  private final String modelName;
}
