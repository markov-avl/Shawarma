package ru.sccs.actor;

import ru.sccs.command.CookIngredientCommand;
import ru.sccs.command.TakeIngredientCommand;
import ru.sccs.cooking.device.Oven;
import ru.sccs.cooking.device.Pan;
import ru.sccs.cooking.device.Pot;
import ru.sccs.model.Order;
import ru.sccs.model.OrderPosition;
import ru.sccs.recipe.Recipe;
import ru.sccs.recipe.RecipeIngredient;
import ru.sccs.recipe.RecipeStep;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecipeFormer {

    private static final Integer DEFAULT_GRAM = 50;

    public static Map<OrderPosition, Recipe> recipesOf(Order order) {
        return order.getPositions().stream()
                .collect(Collectors.toMap(Function.identity(), RecipeFormer::recipeOf));
    }

    public static Recipe recipeOf(OrderPosition position) {
        List<RecipeIngredient> ingredients = position.getDish().getComposition().stream()
                .filter(ingredient -> !position.getExcludedIngredients().contains(ingredient))
                .map(ingredient -> {
                    Integer additionalPortions = position.getAdditionalIngredients().getOrDefault(ingredient, 0);
                    Integer gram = DEFAULT_GRAM * (1 + additionalPortions);
                    return new RecipeIngredient(ingredient.getName(), gram);
                })
                .toList();

        List<RecipeStep> steps = ingredients.stream()
                .map(RecipeFormer::stepFor)
                .toList();

        return new Recipe(ingredients, steps);
    }

    private static RecipeStep stepFor(RecipeIngredient ingredient) {
        if (ingredient.getName().startsWith("Вар")) {
            return new RecipeStep(Pot.class, device -> new CookIngredientCommand(device, ingredient));
        } else if (ingredient.getName().startsWith("Запеч")) {
            return new RecipeStep(Oven.class, device -> new CookIngredientCommand(device, ingredient));
        } else if (ingredient.getName().startsWith("Жар")) {
            return new RecipeStep(Pan.class, device -> new CookIngredientCommand(device, ingredient));
        }
        return new RecipeStep(null, device -> new TakeIngredientCommand(ingredient));
    }

}
