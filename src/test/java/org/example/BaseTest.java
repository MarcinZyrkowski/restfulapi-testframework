package org.example;

import org.example.client.module.item.ItemClient;
import org.example.controller.module.item.ItemController;
import org.junit.jupiter.api.Tag;

@Tag("full")
public class BaseTest {

  protected ItemController itemController = new ItemController();
  protected ItemClient itemClient = new ItemClient();

}
