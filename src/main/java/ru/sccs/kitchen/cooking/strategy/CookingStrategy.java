package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

public interface CookingStrategy {

    Ingredient cook(DeviceFactory deviceFactory, RecipeIngredient ingredient);

}
