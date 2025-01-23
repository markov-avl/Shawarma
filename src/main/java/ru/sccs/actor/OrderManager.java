package ru.sccs.actor;

import lombok.RequiredArgsConstructor;
import ru.sccs.model.menu.Menu;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.Order;
import ru.sccs.model.order.OrderPosition;
import ru.sccs.visitor.PriceCalculator;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class OrderManager {

    private final Menu menu;

    public Order makeTestOrder() {
        MenuDish dish1 = findDishByName("Шаурма с курицей и грибами");
        MenuDish dish2 = findDishByName("Шаурма классическая");
        MenuIngredient vegetable1 = findIngredientByName("Огурец свежий");
        MenuIngredient vegetable2 = findIngredientByName("Помидор свежий");

        return new Order()
                .addPosition(new OrderPosition().setQuantity(3).setDish(dish1))
                .addPosition(new OrderPosition().setQuantity(2).setDish(dish2)
                        .setAdditionalIngredients(Map.of(vegetable1, 3))
                )
                .addPosition(new OrderPosition().setQuantity(2).setDish(dish2)
                        .setExcludedIngredients(List.of(vegetable2))
                )
                .addPosition(new OrderPosition().setQuantity(2).setDish(dish2)
                        .setAdditionalIngredients(Map.of(vegetable2, 2))
                        .setExcludedIngredients(List.of(vegetable2))
                );
    }

    public void printOrder(Order order) {
        PriceCalculator calculator = new PriceCalculator(menu);
        order.print(calculator);
    }

    private MenuDish findDishByName(String name) {
        return menu.getDishes().keySet().stream()
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
