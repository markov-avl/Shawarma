package ru.sccs.command;

import lombok.AllArgsConstructor;
import ru.sccs.cooking.device.Cooking;
import ru.sccs.cooking.ingredient.Ingredient;

// Команда для приготовления ингредиента
@AllArgsConstructor
public class CookIngredientCommand implements Command {

  private Cooking device;

  private Ingredient ingredient;

  @Override
  public void execute() {
    device.cook(ingredient);
  }
}
