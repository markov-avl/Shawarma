package ru.sccs.actor;

import lombok.RequiredArgsConstructor;
import ru.sccs.builder.OrderBuilder;
import ru.sccs.builder.OrderPositionBuilder;
import ru.sccs.model.menu.Menu;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.Order;
import ru.sccs.visitor.PriceCalculator;


@RequiredArgsConstructor
public class OrderManager {

    private final Menu menu;

    public Order makeTestOrder() {
        MenuDish dish1 = findDishByName("Шаурма с курицей и грибами");
        MenuDish dish2 = findDishByName("Шаурма классическая");
        MenuIngredient vegetable1 = findIngredientByName("Огурец свежий");
        MenuIngredient vegetable2 = findIngredientByName("Помидор свежий");

        return new OrderBuilder()
                .addPosition(new OrderPositionBuilder(dish1)
                        .plus(2)
                        .build()
                )
                .addPosition(new OrderPositionBuilder(dish1)
                        .plus()
                        .addIngredient(vegetable1, 3)
                        .build()
                )
                .addPosition(new OrderPositionBuilder(dish2)
                        .minus()
                        .excludeIngredient(vegetable2)
                        .build()
                )
                .addPosition(new OrderPositionBuilder(dish2)
                        .addIngredient(vegetable2, 2)
                        .excludeIngredient(vegetable2)
                        .build()
                )
                .build();
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
