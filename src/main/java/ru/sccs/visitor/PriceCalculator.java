package ru.sccs.visitor;

import ru.sccs.model.menu.Menu;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.order.OrderPosition;

public class PriceCalculator implements Visitor {

    private final Menu menu;

    public PriceCalculator(Menu menu) {
        this.menu = menu;
    }

    @Override
    public double visit(OrderPosition position) {
        MenuDish dish = position.getDish();
        double basePrice = menu.getDishes().getOrDefault(dish, 0.0);

        double additionalPrice = position.getAdditionalIngredients().entrySet().stream()
                .mapToDouble(entry -> menu.getIngredients().getOrDefault(entry.getKey(), 0.0) * entry.getValue())
                .sum();

        double excludedPrice = position.getExcludedIngredients().stream()
                .mapToDouble(ingredient -> menu.getIngredients().getOrDefault(ingredient, 0.0))
                .sum();

        return (basePrice + additionalPrice - excludedPrice) * position.getQuantity();
    }
}
