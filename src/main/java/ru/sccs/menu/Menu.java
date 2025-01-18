package ru.sccs.menu;

import java.util.Map;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Menu {

    // Меню блюд (шаурм)
    private final Map<MenuDish, Double> dishes;

    // Меню дополнительных ингредиентов для блюд
    private final Map<MenuIngredient, Double> ingredients;

    public void printDishesPrices() {
        if (dishes == null || dishes.isEmpty()) {
            System.out.println("В меню ещё нет блюд");
            return;
        }

        System.out.println("БЛЮДА");
        dishes.forEach((dish, price) -> System.out.printf("%-31s : %.2f\n", dish.getName(), price));
    }

    public void printIngredientPrices() {
        if (dishes == null || dishes.isEmpty()) {
            System.out.println("В меню ещё нет дополнительных опций");
            return;
        }

        System.out.println("ДОПОЛНИТЕЛЬНЫЕ ОПЦИИ");
        ingredients.forEach((ingredient, price) -> System.out.printf("%-31s : %.2f\n", ingredient.getName(), price));
    }
}
