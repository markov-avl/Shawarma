package ru.sccs.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.recipe.RecipeIngredient;

/**
 * Сковорода
 */
@Data
@AllArgsConstructor
public class Pan implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(RecipeIngredient ingredient) {
        System.out.printf("Жарится ингредиент '%s' на сковороде '%s'\n", ingredient.getName(), name);
        return new Ingredient(ingredient.getName());
    }
}
