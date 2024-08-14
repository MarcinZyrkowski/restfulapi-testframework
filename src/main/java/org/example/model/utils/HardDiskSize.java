package org.example.model.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HardDiskSize {

  HD128GB("128 GB"),
  HD256GB("256 GB"),
  HD512GB("512 GB"),
  HD1TB("1 TB"),
  HD2TB("2 TB"),
  HD5TB("5 TB");

  private final String size;
}
