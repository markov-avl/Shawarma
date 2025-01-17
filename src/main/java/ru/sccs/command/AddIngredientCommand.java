package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.model.Shawarma;

// Команда для добавления ингредиента
@AllArgsConstructor
public class AddIngredientCommand implements Command {

  private Shawarma shawarma;

  private Ingredient ingredient;

  @Override
  public void execute() {
    shawarma.addIngredient(ingredient);
  }
}
