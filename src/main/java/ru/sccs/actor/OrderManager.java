package ru.sccs.actor;

import lombok.RequiredArgsConstructor;
import ru.sccs.menu.Menu;
import ru.sccs.menu.MenuDish;
import ru.sccs.menu.MenuIngredient;
import ru.sccs.model.Order;
import ru.sccs.model.OrderPosition;
import ru.sccs.visitor.PriceCalculator;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class OrderManager {

    private final Menu menu;

    public Order makeTestOrder() {
        MenuDish dish1 = findDishByName("Шаурма с курицей и грибами");
        MenuDish dish2 = findDishByName("Шаурма классическая");
        MenuIngredient cheese1 = findIngredientByName("Сыр Мацарелла");
        MenuIngredient cheese2 = findIngredientByName("Сыр Маскарпоне");

        return new Order()
                .addPosition(new OrderPosition().setQuantity(3).setDish(dish1))
                .addPosition(new OrderPosition().setQuantity(2).setDish(dish2)
                        .setAdditionalIngredients(Map.of(cheese1, 3))
                )
                .addPosition(new OrderPosition().setQuantity(2).setDish(dish2)
                        .setExcludedIngredients(List.of(cheese2))
                )
                .addPosition(new OrderPosition().setQuantity(2).setDish(dish2)
                        .setAdditionalIngredients(Map.of(cheese2, 2))
                        .setExcludedIngredients(List.of(cheese2))
                );
    }

    public void printOrder(Order order) {
        PriceCalculator calculator = new PriceCalculator(menu);
        order.print(calculator);
    }

    private MenuDish findDishByName(String name) {
        return menu.getShawarmas().keySet().stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .orElseThrow();
    }

    private MenuIngredient findIngredientByName(String name) {
        return menu.getIngredients().keySet().stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .orElseThrow();
    }


}
