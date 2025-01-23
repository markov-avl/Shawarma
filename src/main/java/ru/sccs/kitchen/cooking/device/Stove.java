package ru.sccs.kitchen.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

/**
 * Плита
 */
@Data
@AllArgsConstructor
public class Stove implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(RecipeIngredient ingredient) {
        System.out.printf("Запекается ингредиент '%s' в печи '%s'\n", ingredient.getName(), name);
        return new Ingredient(ingredient.getName());
    }

}
