package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.model.Ingredient;

public interface CookingStrategy {

    Ingredient cook(Ingredient ingredient);

}
