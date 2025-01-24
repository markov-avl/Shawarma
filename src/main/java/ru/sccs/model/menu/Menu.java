package ru.sccs.model.menu;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class Menu {

    // Меню блюд (шаурм)
    private final Map<MenuDish, Double> dishes;

    // Меню дополнительных ингредиентов для блюд
    private final Map<MenuIngredient, Double> ingredients;

}
