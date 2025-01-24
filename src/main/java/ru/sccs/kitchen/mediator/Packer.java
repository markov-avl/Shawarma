package ru.sccs.kitchen.mediator;

import ru.sccs.model.order.Order;

public class Packer extends Colleague {

  public void pack(Order order) {
    order.setStatus("Готов к выдаче");
  }
}
