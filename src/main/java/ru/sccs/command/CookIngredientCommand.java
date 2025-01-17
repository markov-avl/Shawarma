package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.cooking.device.CookingDevice;
import ru.sccs.recipe.RecipeIngredient;

// Команда для приготовления ингредиента
@AllArgsConstructor
public class CookIngredientCommand implements Command {

    private CookingDevice device;

    private RecipeIngredient ingredient;

    @Override
    public void execute() {
        device.cook(ingredient);
    }
}
