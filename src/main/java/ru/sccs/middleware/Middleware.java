package ru.sccs.middleware;

import lombok.Setter;
import ru.sccs.model.order.Order;

@Setter
public abstract class Middleware {

  private Middleware next;

  public void handle(Order order) {
    if(canHandle(order)) {
      process(order);
    }
    if (next != null) {
      next.handle(order);
    }
  }

  protected abstract boolean canHandle(Order order);

  protected abstract void process(Order order);
}
