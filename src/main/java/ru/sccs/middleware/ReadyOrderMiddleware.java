package ru.sccs.middleware;

import lombok.AllArgsConstructor;
import ru.sccs.kitchen.mediator.Packer;
import ru.sccs.model.order.Order;

@AllArgsConstructor
public class ReadyOrderMiddleware extends Middleware {

  private Packer packer;

  @Override
  protected boolean canHandle(Order order) {
    return order.getStatus().equals("Готов");
  }

  @Override
  protected void process(Order order) {
    packer.pack(order);
  }
}
