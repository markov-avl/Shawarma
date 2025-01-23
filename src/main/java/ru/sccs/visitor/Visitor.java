package ru.sccs.visitor;

import ru.sccs.model.order.OrderPosition;

public interface Visitor {
  double visit(OrderPosition position);
}
