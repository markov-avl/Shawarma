package ru.sccs.middleware;

import ru.sccs.model.order.Order;

public class ReadyOrderMiddleware extends Middleware {

  @Override
  protected boolean canHandle(Order order) {
    return order.getStatus().equals("Готов");
  }

  @Override
  protected void process(Order order) {
    System.out.println("Заказ готов");
    order.setStatus("Можно забирать");
  }
}
