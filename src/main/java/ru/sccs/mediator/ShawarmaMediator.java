package ru.sccs.mediator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.sccs.command.AddIngredientCommand;
import ru.sccs.command.Chef;
import ru.sccs.command.CookIngredientCommand;
import ru.sccs.cooking.device.Grill;
import ru.sccs.cooking.device.Oven;
import ru.sccs.cooking.device.Pan;
import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.model.Order;
import ru.sccs.model.Shawarma;

@NoArgsConstructor
@AllArgsConstructor
public class ShawarmaMediator implements Mediator {

  private Grill grill = new Grill("Гриль");

  private Oven oven = new Oven("Духовка");

  private Pan pan = new Pan("Кастрюля");

  private Chef chef = new Chef();

  public void cookShawarma(Order order) {
    // Находить рецепт для шаурмы, передавать туда шефа, возвращаться шефа с командами
    order.getPositions().forEach(position -> {
      Shawarma shawarma = position.getShawarma();
      shawarma.getIngredients().forEach(ingredient -> {
        chef.addCommand(new CookIngredientCommand(grill, ingredient));
        chef.addCommand(new AddIngredientCommand(shawarma, ingredient));
      });
    });

    chef.prepareShawarma();
  }

  @Override
  public void packageShawarma() {

  }

  @Override
  public void packageOrder() {

  }
}
