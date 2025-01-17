package ru.sccs.menu;

import java.util.Map;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Menu {

    // Меню шаурм
    private final Map<MenuDish, Double> shawarmas;

    // Меню дополнительных ингредиентов для блюд
    private final Map<MenuIngredient, Double> ingredients;

    public void printShawarmaPrices() {
        System.out.println("----------------- Меню -----------------");
        if (shawarmas == null || shawarmas.isEmpty()) {
            System.out.println("В меню ещё нет шаурмы");
            return;
        }

        shawarmas.forEach((shawarma, price) -> System.out.printf("%-31s : %.2f\n", shawarma.getName(), price));
        System.out.println("----------------------------------------");
    }
}
