package ru.sccs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.mediator.ShawarmaMediator;
import ru.sccs.model.Menu;
import ru.sccs.model.Order;
import ru.sccs.model.OrderPosition;
import ru.sccs.model.Shawarma;
import ru.sccs.visitor.PriceCalculator;

public class ShawarmaCookingControlSystem {

//    public static final List<Ingredient> ingredients = List.of(
//
//    );
//
//    public static final List<Shawarma> shawarmas = List.of(
//            new Shawarma("Стандарт", List.of())
//    );
//
//    public static final Menu menu = new Menu(
//            Map.of(),
//            Map.of()
//    );

  public static void main(String[] args) {
    // Ingredients
    var pita1 = new Ingredient("Лаваш пшеничный");
    var pita2 = new Ingredient("Пита мексиканская");

    var chicken1 = new Ingredient("Курица жареная");
    var chicken2 = new Ingredient("Курица вареная");
    var meat1 = new Ingredient("Свинной фарш");
    var kebab1 = new Ingredient("Свинной шашлык");

    var cucumber1 = new Ingredient("Огурец свежий");
    var cucumber2 = new Ingredient("Огурец малосольный");
    var tomato1 = new Ingredient("Помидор свежий");
    var tomato2 = new Ingredient("Помидор малосольный");

    var cheese1 = new Ingredient("Сыр Чеддр");
    var cheese2 = new Ingredient("Сыр Мацарелла");
    var cheese3 = new Ingredient("Сыр Маскарпоне");
    var cheese4 = new Ingredient("Сыр Российский");

    var souse1 = new Ingredient("Майонез");
    var souse2 = new Ingredient("Кетчуп");
    var souse3 = new Ingredient("Соус Ранч");
    var souse4 = new Ingredient("Соус 1000 островов");

    var mushrooms1 = new Ingredient("Грибы Опята");
    var mushrooms2 = new Ingredient("Грибы Шампиньоны");
    var mushrooms3 = new Ingredient("Грибы Подберезовики");

    var potato1 = new Ingredient("Картошка жареная");
    var potato2 = new Ingredient("Картошка пюре");

    // Shawarmas
    var s1 = new Shawarma("Шаурма с курицей и грибами", new ArrayList<>(
        List.of(pita1, chicken1, cucumber1, tomato1, cheese4, souse1, mushrooms1, mushrooms2,
            mushrooms3)));
    var s2 = new Shawarma("Шаурма классическая", new ArrayList<>(
        List.of(pita1, chicken1, cucumber1, tomato1, cheese4, souse1, souse2)));
    var s3 = new Shawarma("Шаурма с шашлыком", new ArrayList<>(
        List.of(pita1, kebab1, cucumber2, cucumber1, tomato1, tomato2, cheese1, cheese4, souse1,
            souse2, souse4)));
    var s4 = new Shawarma("Шаурма Free", new ArrayList<>(
        List.of(pita1, kebab1, cucumber2, cucumber1, tomato1, tomato2, potato1, cheese1, cheese4,
            souse1, souse2, souse4)));
    var s5 = new Shawarma("Шаурма Fuck My Ass", new ArrayList<>(
        List.of(pita2, kebab1, chicken2, meat1, cucumber2, cucumber1, tomato1, tomato2, potato1,
            cheese1, cheese2, cheese3, cheese4, souse1, souse2, souse3, souse4, mushrooms1,
            mushrooms2, mushrooms3, potato1, potato2))
    );

    // Menu
    var menu = new Menu(
        Map.of(s1, 250d, s2, 300d, s3, 350d, s4, 450d, s5, 980d),
        Map.ofEntries(Map.entry(chicken1, 30d), Map.entry(chicken2, 25d), Map.entry(meat1, 33.5),
            Map.entry(kebab1, 37.75), Map.entry(cucumber1, 12.2), Map.entry(cucumber2, 12.3),
            Map.entry(tomato1, 13.7), Map.entry(tomato2, 13.8), Map.entry(cheese1, 15.2),
            Map.entry(cheese2, 15.4), Map.entry(cheese3, 15.6), Map.entry(cheese4, 15.8),
            Map.entry(souse1, 16.2), Map.entry(souse2, 16.4), Map.entry(souse3, 16.6),
            Map.entry(souse4, 16.8), Map.entry(mushrooms1, 17.2), Map.entry(mushrooms2, 17.4),
            Map.entry(mushrooms3, 17.6), Map.entry(potato1, 18.2), Map.entry(potato2, 18.4))
    );

    menu.printShawarmaPrices();

    Order order = new Order()
        .addPosition(new OrderPosition().setQuantity(3).setShawarma(s1))
        .addPosition(new OrderPosition().setQuantity(2).setShawarma(s2)
            .setAdditionalIngredients(Map.of(cheese2, 3)))
        .addPosition(new OrderPosition().setQuantity(2).setShawarma(s2)
            .setExcludedIngredients(List.of(cheese3)))
        .addPosition(new OrderPosition().setQuantity(2).setShawarma(s2)
            .setAdditionalIngredients(Map.of(cheese2, 2)).setExcludedIngredients(List.of(cheese3)));

    PriceCalculator calculator = new PriceCalculator(menu);
    order.print(calculator);

    ShawarmaMediator mediator = new ShawarmaMediator();
    mediator.cookShawarma(order);
  }
}