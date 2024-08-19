package org.example;

import org.example.annotations.Full;
import org.example.client.module.item.ItemClient;
import org.example.controller.module.item.ItemController;

public class BaseTest implements Full {

  protected ItemController itemController = new ItemController();
  protected ItemClient itemClient = new ItemClient();

}
