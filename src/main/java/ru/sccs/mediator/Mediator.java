package ru.sccs.mediator;

import ru.sccs.model.Order;

public interface Mediator {

  void cookShawarma(Order order);

  void packageShawarma();

  void packageOrder();
}
