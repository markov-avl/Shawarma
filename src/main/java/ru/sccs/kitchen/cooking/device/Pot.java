package ru.sccs.kitchen.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

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
