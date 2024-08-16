package org.example.model.utils.service.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Phone {

  IPHONE_13("iPhone 13"),
  IPHONE_13_PRO("iPhone 13 Pro"),
  IPHONE_13_PRO_MAX("iPhone 13 Pro Max"),
  IPHONE_14("iPhone 14"),
  IPHONE_14_PRO("iPhone 14 Pro"),
  IPHONE_14_PRO_MAX("iPhone 14 Pro Max"),
  SAMSUNG_GALAXY_S21("Samsung Galaxy S21"),
  SAMSUNG_GALAXY_S21_ULTRA("Samsung Galaxy S21 Ultra"),
  GOOGLE_PIXEL_6("Google Pixel 6"),
  GOOGLE_PIXEL_6_PRO("Google Pixel 6 Pro"),
  ONEPLUS_9("OnePlus 9"),
  ONEPLUS_9_PRO("OnePlus 9 Pro"),
  XIAOMI_MI_11("Xiaomi Mi 11"),
  XIAOMI_MI_11_ULTRA("Xiaomi Mi 11 Ultra"),
  HUAWEI_P40("Huawei P40"),
  HUAWEI_P40_PRO("Huawei P40 Pro"),
  SONY_XPERIA_1_III("Sony Xperia 1 III"),
  MOTOROLA_EDGE_20("Motorola Edge 20"),
  NOKIA_X20("Nokia X20"),
  OPPO_FIND_X3("Oppo Find X3");

  private final String name;
}
