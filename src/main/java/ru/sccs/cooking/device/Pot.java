package ru.sccs.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.recipe.RecipeIngredient;

/**
 * Кастрюля
 */
@Data
@AllArgsConstructor
public class Pot implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(RecipeIngredient ingredient) {
        System.out.printf("Варится ингредиент '%s' в кастрюле '%s'\n", ingredient.getName(), name);
        return new Ingredient(ingredient.getName());
    }
}
