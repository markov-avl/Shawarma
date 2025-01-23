package ru.sccs.visitor;

import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.Order;
import ru.sccs.model.order.OrderPosition;

public interface OrderVisitor {

    Double visit(Order order);

    Double visit(OrderPosition position);

    Double visit(MenuDish menuDish);

    Double visit(MenuIngredient ingredient);

}
