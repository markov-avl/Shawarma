package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.model.recipe.RecipeIngredient;

// Команда для обжарки ингредиента
@AllArgsConstructor
public class FryIngredientCommand implements Command {

    private RecipeIngredient ingredient;

    @Override
    public void execute(KitchenFacade kitchenFacade) {
        kitchenFacade.fry(ingredient);
    }
}
