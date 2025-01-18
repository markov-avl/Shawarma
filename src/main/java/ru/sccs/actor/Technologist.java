package ru.sccs.actor;

import ru.sccs.menu.Menu;
import ru.sccs.menu.MenuDish;
import ru.sccs.menu.MenuIngredient;

import java.util.List;
import java.util.Map;

public class Technologist {

    public static Menu createMenu() {
        // Лаваши
        var pita1 = new MenuIngredient("Лаваш пшеничный");
        var pita2 = new MenuIngredient("Пита мексиканская");

        // Мясо
        var chicken1 = new MenuIngredient("Жареная курица");
        var chicken2 = new MenuIngredient("Вареная курица");
        var meat1 = new MenuIngredient("Свинной фарш");
        var kebab1 = new MenuIngredient("Свинной шашлык");

        // Овощи
        var cucumber1 = new MenuIngredient("Огурец свежий");
        var cucumber2 = new MenuIngredient("Огурец малосольный");
        var tomato1 = new MenuIngredient("Помидор свежий");
        var tomato2 = new MenuIngredient("Помидор малосольный");
        var potato1 = new MenuIngredient("Жареный картофель");
        var potato2 = new MenuIngredient("Картошка пюре");

        // Сыры
        var cheese1 = new MenuIngredient("Сыр Чеддр");
        var cheese2 = new MenuIngredient("Сыр Мацарелла");
        var cheese3 = new MenuIngredient("Сыр Маскарпоне");
        var cheese4 = new MenuIngredient("Сыр Российский");

        // Соусы
        var souse1 = new MenuIngredient("Майонез");
        var souse2 = new MenuIngredient("Кетчуп");
        var souse3 = new MenuIngredient("Соус Ранч");
        var souse4 = new MenuIngredient("Соус 1000 островов");

        // Грибы
        var mushrooms1 = new MenuIngredient("Грибы Опята");
        var mushrooms2 = new MenuIngredient("Грибы Шампиньоны");
        var mushrooms3 = new MenuIngredient("Грибы Подберезовики");

        // Блюда
        var dish1 = new MenuDish(
                "Шаурма с курицей и грибами",
                List.of(pita1, chicken1, cucumber1, tomato1, cheese4, souse1, mushrooms1, mushrooms2, mushrooms3)
        );
        var dish2 = new MenuDish(
                "Шаурма классическая",
                List.of(pita1, chicken1, cucumber1, tomato1, cheese4, souse1, souse2)
        );
        var dish3 = new MenuDish(
                "Шаурма с шашлыком",
                List.of(pita2, kebab1, cucumber2, cucumber1, tomato1, tomato2, cheese1, cheese4, souse1, souse2, souse4)
        );

        return new Menu(
                Map.ofEntries(
                        Map.entry(dish1, 250d),
                        Map.entry(dish2, 300d),
                        Map.entry(dish3, 350d)
                ),
                Map.ofEntries(
                        Map.entry(chicken1, 30d),
                        Map.entry(chicken2, 25d),
                        Map.entry(meat1, 33.5),
                        Map.entry(kebab1, 37.75),
                        Map.entry(cucumber1, 12.2),
                        Map.entry(cucumber2, 12.3),
                        Map.entry(tomato1, 13.7),
                        Map.entry(tomato2, 13.8),
                        Map.entry(cheese1, 15.2),
                        Map.entry(cheese2, 15.4),
                        Map.entry(cheese3, 15.6),
                        Map.entry(cheese4, 15.8),
                        Map.entry(souse1, 16.2),
                        Map.entry(souse2, 16.4),
                        Map.entry(souse3, 16.6),
                        Map.entry(souse4, 16.8),
                        Map.entry(mushrooms1, 17.2),
                        Map.entry(mushrooms2, 17.4),
                        Map.entry(mushrooms3, 17.6),
                        Map.entry(potato1, 18.2),
                        Map.entry(potato2, 18.4)
                )
        );
    }

    public static void printMenu(Menu menu) {
        System.out.println("----------------- Меню -----------------");
        menu.printDishesPrices();
        System.out.println("----------------------------------------");
        menu.printIngredientPrices();
        System.out.println("----------------------------------------");
    }

}
