package org.example.factory;

import org.example.model.Item;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class ItemsFactory {

    public static Stream<Arguments> provideItemsWithIds357() {
        Item itemWithId3 = Item.builder()
                .id("3")
                .name("Apple iPhone 12 Pro Max")
                .data(Item.Data.builder()
                        .color("Cloudy White")
                        .capacity(512)
                        .build())
                .build();
        Item itemWithId5 = Item.builder()
                .id("5")
                .name("Samsung Galaxy Z Fold2")
                .data(Item.Data.builder()
                        .price(689.99)
                        .color("Brown")
                        .build())
                .build();
        Item itemWithId7 = Item.builder()
                .id("7")
                .name("Apple MacBook Pro 16")
                .data(Item.Data.builder()
                        .year(2019)
                        .price(1849.99)
                        .cpuModel("Intel Core i9")
                        .hardDiskSize("1 TB")
                        .build())
                .build();

        return Stream.of(
                Arguments.of(List.of(itemWithId3,
                        itemWithId5,
                        itemWithId7))
        );
    }

}
