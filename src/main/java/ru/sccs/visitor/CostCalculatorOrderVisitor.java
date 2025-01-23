package ru.sccs.visitor;

import lombok.RequiredArgsConstructor;
import ru.sccs.model.menu.Menu;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.Order;
import ru.sccs.model.order.OrderPosition;

@RequiredArgsConstructor
public class CostCalculatorOrderVisitor implements OrderVisitor {

    private final Menu menu;

    @Override
    public Double visit(Order order) {
        return order.getPositions().stream().mapToDouble(this::visit).sum();
    }

    @Override
    public Double visit(OrderPosition position) {
        double additionalIngredientsCost = position.getAdditionalIngredients().entrySet().stream()
                .filter(e -> !position.getExcludedIngredients().contains(e.getKey()))
                .mapToDouble(entry -> visit(entry.getKey()) * entry.getValue())
                .sum();
        double excludedIngredientsCost = position.getExcludedIngredients().stream()
                .mapToDouble(this::visit)
                .sum();
        double cost = Math.max(visit(position.getDish()) + additionalIngredientsCost - excludedIngredientsCost, 150);

        return cost * position.getQuantity();
    }

    @Override
    public Double visit(MenuDish menuDish) {
        return menu.getDishes().get(menuDish);
    }

    @Override
    public Double visit(MenuIngredient ingredient) {
        return menu.getIngredients().get(ingredient);
    }
}
