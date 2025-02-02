package ru.sccs.middleware;

import ru.sccs.model.order.Order;

public class NewOrderMiddleware extends Middleware {

  @Override
  protected boolean canHandle(Order order) {
    return order.getStatus().equals("Новый");
  }

  @Override
  protected void process(Order order) {
    order.setStatus("Готовится");
  }
}
