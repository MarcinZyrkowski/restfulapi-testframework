package org.example.generator;

import java.time.LocalDate;
import java.util.Random;
import org.example.model.service.Item;
import org.example.model.utils.Capacity;
import org.example.model.utils.Colors;
import org.example.model.utils.CpuModel;
import org.example.model.utils.HardDiskSize;
import org.example.model.utils.Laptop;
import org.example.model.utils.Phone;
import org.example.utils.EnumUtils;
import org.example.utils.FakerUtils;

public class ItemGenerator {

  private static final Random RANDOM = new Random();
  private static final int MIN_PRICE = 1;
  private static final int MAX_PRICE = 10_000;
  private static final int MIN_YEAR = 2010;

  public static Item generateRandomItem() {
    return RANDOM.nextBoolean() ? generateRandomLaptop() : generateRandomPhone();
  }

  private static Item generateRandomPhone() {
    return Item.builder()
        .name(EnumUtils.getRandom(Phone.class).getName())
        .data(Item.Data.builder()
            .year(RANDOM.nextInt(MIN_YEAR, LocalDate.now().getYear()))
            .color(EnumUtils.getRandom(Colors.class).getName())
            .price((double) FakerUtils.getFaker().number().numberBetween(MIN_PRICE, MAX_PRICE))
            .capacity(EnumUtils.getRandom(Capacity.class).getSize())
            .cpuModel(EnumUtils.getRandom(CpuModel.class).getModelName())
            .build())
        .build();
  }

  private static Item generateRandomLaptop() {
    return Item.builder()
        .name(EnumUtils.getRandom(Laptop.class).getName())
        .data(Item.Data.builder()
            .year(RANDOM.nextInt(MIN_YEAR, LocalDate.now().getYear()))
            .color(EnumUtils.getRandom(Colors.class).getName())
            .price((double) FakerUtils.getFaker().number().numberBetween(MIN_PRICE, MAX_PRICE))
            .hardDiskSize(EnumUtils.getRandom(HardDiskSize.class).getSize())
            .cpuModel(EnumUtils.getRandom(CpuModel.class).getModelName())
            .build())
        .build();
  }

}
