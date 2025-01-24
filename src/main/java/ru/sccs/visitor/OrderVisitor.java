package ru.sccs.visitor;

import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.Order;
import ru.sccs.model.order.OrderPosition;

public interface OrderVisitor<T> {

    T visit(Order order);

    T visit(OrderPosition position);

    T visit(MenuDish menuDish);

    T visit(MenuIngredient ingredient);

}
