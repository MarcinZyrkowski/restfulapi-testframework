package org.example.db.service.item;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.model.service.restfulapi.item.Item;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemDataBase {

  private static final Map<String, Item> PREDEFINED_ITEMS = fillPredefinedItems();

  private static Map<String, Item> fillPredefinedItems() {
    Map<String, Item> predefineItems = new HashMap<>();
    predefineItems.put("item1", Item.builder()
        .id("1")
        .name("Google Pixel 6 Pro")
        .data(Item.Data.builder()
            .color("Cloudy White")
            .capacity("128 GB")
            .build())
        .build());
    predefineItems.put("item2", Item.builder()
        .id("2")
        .name("Apple iPhone 12 Mini, 256GB, Blue")
        .data(null)
        .build());
    predefineItems.put("item3", Item.builder()
        .id("3")
        .name("Apple iPhone 12 Pro Max")
        .data(Item.Data.builder()
            .color("Cloudy White")
            .capacityGB(512)
            .build())
        .build());
    predefineItems.put("item4", Item.builder()
        .id("4")
        .name("Apple iPhone 11, 64GB")
        .data(Item.Data.builder()
            .price(389.99)
            .color("Purple")
            .build())
        .build());
    predefineItems.put("item5", Item.builder()
        .id("5")
        .name("Samsung Galaxy Z Fold2")
        .data(Item.Data.builder()
            .price(689.99)
            .color("Brown")
            .build())
        .build());
    predefineItems.put("item6", Item.builder()
        .id("6")
        .name("Apple AirPods")
        .data(Item.Data.builder()
            .generation("3rd")
            .price(120.0)
            .build())
        .build());
    predefineItems.put("item7", Item.builder()
        .id("7")
        .name("Apple MacBook Pro 16")
        .data(Item.Data.builder()
            .year(2019)
            .price(1849.99)
            .cpuModel("Intel Core i9")
            .hardDiskSize("1 TB")
            .build())
        .build());
    predefineItems.put("item8", Item.builder()
        .id("8")
        .name("Apple Watch Series 8")
        .data(Item.Data.builder()
            .strapColour("Elderberry")
            .caseSize("41mm")
            .build())
        .build());
    predefineItems.put("item9", Item.builder()
        .id("9")
        .name("Beats Studio3 Wireless")
        .data(Item.Data.builder()
            .Color("Red")
            .description("High-performance wireless noise cancelling headphones")
            .build())
        .build());
    predefineItems.put("item10", Item.builder()
        .id("10")
        .name("Apple iPad Mini 5th Gen")
        .data(Item.Data.builder()
            .Capacity("64 GB")
            .screenSize(7.9)
            .build())
        .build());
    predefineItems.put("item11", Item.builder()
        .id("11")
        .name("Apple iPad Mini 5th Gen")
        .data(Item.Data.builder()
            .Capacity("254 GB")
            .screenSize(7.9)
            .build())
        .build());
    predefineItems.put("item12", Item.builder()
        .id("12")
        .name("Apple iPad Air")
        .data(Item.Data.builder()
            .Generation("4th")
            .Price("419.99")
            .Capacity("64 GB")
            .build())
        .build());
    predefineItems.put("item13", Item.builder()
        .id("13")
        .name("Apple iPad Air")
        .data(Item.Data.builder()
            .Generation("4th")
            .Price("519.99")
            .Capacity("256 GB")
            .build())
        .build());

    return predefineItems;
  }

  public static Map<String, Item> getPredefinedItems() {
    return new HashMap<>(PREDEFINED_ITEMS);
  }

}
