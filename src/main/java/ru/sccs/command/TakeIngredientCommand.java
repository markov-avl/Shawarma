package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.recipe.RecipeIngredient;

// Команда для взятия ингредиента
@AllArgsConstructor
public class TakeIngredientCommand implements Command {

    private RecipeIngredient ingredient;

    @Override
    public void execute() {
        System.out.printf("Взят ингредиент '%s' (%d г.)\n", ingredient.getName(), ingredient.getGram());
    }
}
