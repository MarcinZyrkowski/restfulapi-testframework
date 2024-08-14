package org.example.model.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Laptop {

  MACBOOK_AIR_M1("MacBook Air M1"),
  MACBOOK_PRO_13_M1("MacBook Pro 13 M1"),
  MACBOOK_PRO_16_M1("MacBook Pro 16 M1"),
  DELL_XPS_13("Dell XPS 13"),
  DELL_XPS_15("Dell XPS 15"),
  HP_SPECTRE_X360("HP Spectre x360"),
  LENOVO_THINKPAD_X1_CARBON("Lenovo ThinkPad X1 Carbon"),
  LENOVO_YOGA_9I("Lenovo Yoga 9i"),
  ASUS_ZENBOOK_13("Asus ZenBook 13"),
  ASUS_ROG_ZEUS("Asus ROG Zephyrus"),
  MICROSOFT_SURFACE_LAPTOP_4("Microsoft Surface Laptop 4"),
  ACER_SWIFT_3("Acer Swift 3"),
  RAZER_BLADE_15("Razer Blade 15"),
  MSI_GS66_STEALTH("MSI GS66 Stealth"),
  HP_ENVY_13("HP Envy 13"),
  SAMSUNG_GALAXY_BOOK_PRO("Samsung Galaxy Book Pro"),
  DELL_INSPIRON_15("Dell Inspiron 15"),
  LENOVO_LEGION_5("Lenovo Legion 5"),
  ASUS_VIVOBOOK_15("Asus VivoBook 15"),
  TOSHIBA_PORTAGE_X20W("Toshiba Portégé X20W");

  private final String name;

}
