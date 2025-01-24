package ru.sccs.printer;

import ru.sccs.model.menu.Menu;

public class MenuPrinter {

    public static void print(Menu menu) {
        System.out.println("----------------- Меню -----------------");
        printDishesPrices(menu);
        System.out.println("----------------------------------------");
        printIngredientPrices(menu);
        System.out.println("----------------------------------------");
    }

    public static void printDishesPrices(Menu menu) {
        if (menu.getDishes() == null || menu.getDishes().isEmpty()) {
            System.out.println("В меню ещё нет блюд");
            return;
        }

        System.out.println("БЛЮДА");
        menu.getDishes().forEach((dish, price) -> System.out.printf("%-31s : %.2f\n", dish.getName(), price));
    }

    public static void printIngredientPrices(Menu menu) {
        if (menu.getIngredients() == null || menu.getIngredients().isEmpty()) {
            System.out.println("В меню ещё нет дополнительных опций");
            return;
        }

        System.out.println("ДОПОЛНИТЕЛЬНЫЕ ОПЦИИ");
        menu.getIngredients().forEach((ingredient, price) -> System.out.printf("%-31s : %.2f\n", ingredient.getName(), price));
    }

}
