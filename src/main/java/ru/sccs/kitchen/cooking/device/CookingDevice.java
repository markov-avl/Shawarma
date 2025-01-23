package ru.sccs.kitchen.cooking.device;

import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

public interface CookingDevice {

    Ingredient cook(RecipeIngredient ingredient);
}
