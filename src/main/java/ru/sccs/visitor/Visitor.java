package ru.sccs.visitor;

import ru.sccs.model.OrderPosition;

public interface Visitor {
  double visit(OrderPosition position);
}
