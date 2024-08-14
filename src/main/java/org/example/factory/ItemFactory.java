package org.example.factory;

import java.util.stream.Stream;
import org.example.generator.ItemGenerator;
import org.example.model.service.Item;
import org.junit.jupiter.params.provider.Arguments;

public class ItemFactory {

  public static Stream<Arguments> provideItemWithId7() {
    return Stream.of(
        Arguments.of(Item.builder()
            .id("7")
            .name("Apple MacBook Pro 16")
            .data(Item.Data.builder()
                .year(2019)
                .price(1849.99)
                .cpuModel("Intel Core i9")
                .hardDiskSize("1 TB")
                .build())
            .build())
    );
  }

  public static Stream<Arguments> provideRandomItem() {
    return Stream.of(
        Arguments.of(ItemGenerator.generateRandomItem())
    );
  }

}
