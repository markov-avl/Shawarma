package ru.sccs.cooking.device;

import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.recipe.RecipeIngredient;

public interface CookingDevice {

    Ingredient cook(RecipeIngredient ingredient);
}
