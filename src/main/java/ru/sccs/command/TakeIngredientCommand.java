package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

// Команда для взятия ингредиента
@AllArgsConstructor
public class TakeIngredientCommand implements Command {

    private RecipeIngredient recipeIngredient;

    @Override
    public void execute(KitchenFacade kitchenFacade) {
        Ingredient ingredient = kitchenFacade.takeIngredient(recipeIngredient);
    }
}
