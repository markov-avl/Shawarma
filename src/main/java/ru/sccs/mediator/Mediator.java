package ru.sccs.mediator;

import ru.sccs.model.Order;

public interface Mediator {

  void cookOrder(Order order);

  void packageShawarma();

  void packageOrder();
}
