package ru.sccs.builder;

import lombok.RequiredArgsConstructor;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.OrderPosition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class OrderPositionBuilder {

    private final MenuDish menuDish;

    private final Map<MenuIngredient, Integer> additionalIngredients = new HashMap<>();

    private final Set<MenuIngredient> excludedIngredients = new HashSet<>();

    private Integer quantity = 1;

    public OrderPositionBuilder plus() {
        return plus(1);
    }

    public OrderPositionBuilder plus(Integer delta) {
        quantity = Math.min(quantity + delta, 10);
        return this;
    }

    public OrderPositionBuilder minus() {
        return minus(1);
    }

    public OrderPositionBuilder minus(Integer delta) {
        quantity = Math.max(quantity - delta, 1);
        return this;
    }

    public OrderPositionBuilder addIngredient(MenuIngredient ingredient) {
        return addIngredient(ingredient, 1);
    }

    public OrderPositionBuilder addIngredient(MenuIngredient ingredient, Integer quantity) {
        additionalIngredients.put(ingredient, additionalIngredients.getOrDefault(ingredient, 0) + quantity);
        additionalIngredients.computeIfPresent(ingredient, (i, q) -> Math.min(q, 10));
        return this;
    }

    public OrderPositionBuilder excludeIngredient(MenuIngredient ingredient) {
        excludedIngredients.add(ingredient);
        return this;
    }

    public OrderPosition build() {
        return new OrderPosition(menuDish, quantity, additionalIngredients, List.copyOf(excludedIngredients));
    }

}
