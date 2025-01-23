package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.model.recipe.RecipeIngredient;

// Команда для варения ингредиента
@AllArgsConstructor
public class BoilIngredientCommand implements Command {

    private RecipeIngredient ingredient;

    @Override
    public void execute(KitchenFacade kitchenFacade) {
        kitchenFacade.boil(ingredient);
    }
}
