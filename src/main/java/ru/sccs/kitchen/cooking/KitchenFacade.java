package ru.sccs.kitchen.cooking;

import ru.sccs.kitchen.cooking.strategy.BakingStrategy;
import ru.sccs.kitchen.cooking.strategy.BoilingStrategy;
import ru.sccs.kitchen.cooking.strategy.CookingStrategy;
import ru.sccs.kitchen.cooking.strategy.FryingStrategy;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

import java.util.Map;

public class KitchenFacade {

    private final Map<String, CookingStrategy> cookingStrategies = Map.of(
            "Жар", new FryingStrategy(),
            "Запеч", new BakingStrategy(),
            "Вар", new BoilingStrategy()
    );

    public Ingredient takeIngredient(RecipeIngredient recipeIngredient) {
        Ingredient ingredient = IngredientFactory.getByRecipe(recipeIngredient);
        System.out.printf("Взят ингредиент '%s'\n", ingredient);

        return cookIfNeeded(ingredient, recipeIngredient);
    }

    private Ingredient cookIfNeeded(Ingredient ingredient, RecipeIngredient recipeIngredient) {
        if (ingredient.getName().equals(recipeIngredient.getName())) {
            return ingredient;
        }

        CookingStrategy strategy = cookingStrategies.entrySet().stream()
                .filter(entry -> recipeIngredient.getName().startsWith(entry.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow();

        return strategy.cook(ingredient);
    }

}
