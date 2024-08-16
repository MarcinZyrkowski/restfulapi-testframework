package org.example.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.example.db.service.item.ItemDataBase;
import org.example.generator.ItemGenerator;
import org.example.model.service.restfulapi.item.Item;
import org.junit.jupiter.params.provider.Arguments;

public class ItemsFactory {

  public static Stream<Arguments> provideItemsWithIds357() {
    Item itemWithId3 = ItemDataBase.getPredefinedItems().get("item3");
    Item itemWithId5 = ItemDataBase.getPredefinedItems().get("item5");
    Item itemWithId7 = ItemDataBase.getPredefinedItems().get("item7");

    return Stream.of(
        Arguments.of(List.of(itemWithId3,
            itemWithId5,
            itemWithId7))
    );
  }

  public static Stream<Arguments> provideItemAndItsUpdatedVersion() {
    return Stream.of(
        Arguments.of(
            ItemGenerator.generateRandomItem(),
            ItemGenerator.generateRandomItem()
        )
    );
  }

  public static Stream<Arguments> provideAllPredefineItems() {
    List<Item> allItems = new ArrayList<>(ItemDataBase.getPredefinedItems().values());

    return Stream.of(
        Arguments.of(allItems)
    );
  }

}
