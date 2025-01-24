package ru.sccs.kitchen.cooking;

import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

import java.util.Random;

public class IngredientFactory {

    private static final Random RANDOM = new Random();

    public static Ingredient getByRecipe(RecipeIngredient recipeIngredient) {
        String ingredient = recipeIngredient.getName();
        if (canBeCooked(ingredient) && RANDOM.nextBoolean()) {
            ingredient = ingredient.substring(ingredient.indexOf(" ") + 1);
        }
        return new Ingredient(ingredient);
    }

    private static boolean canBeCooked(String ingredient) {
        return ingredient.startsWith("Вар") || ingredient.startsWith("Запеч") || ingredient.startsWith("Жар");
    }

}
