package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.model.recipe.RecipeIngredient;

// Команда для взятия ингредиента
@AllArgsConstructor
public class TakeIngredientCommand implements Command {

    private RecipeIngredient ingredient;

    @Override
    public void execute(KitchenFacade kitchenFacade) {
        System.out.printf("Взят ингредиент '%s' (%d г.)\n", ingredient.getName(), ingredient.getGram());
    }
}
