package org.example;

import org.example.annotation.Full;
import org.example.client.module.item.ItemClient;
import org.example.controller.module.item.ItemController;

@Full
public class BaseTest {

  protected ItemController itemController = new ItemController();
  protected ItemClient itemClient = new ItemClient();

}
