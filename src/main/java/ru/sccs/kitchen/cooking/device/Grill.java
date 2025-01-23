package ru.sccs.kitchen.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

/**
 * Гриль
 */
@Data
@AllArgsConstructor
public class Grill implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(RecipeIngredient ingredient) {
        System.out.printf("Жарится ингредиент '%s' на грилле '%s'\n", ingredient.getName(), name);
        return new Ingredient(ingredient.getName());
    }

}
