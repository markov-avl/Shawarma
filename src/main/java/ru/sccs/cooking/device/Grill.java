package ru.sccs.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;

/**
 * Гриль
 */
@Data
@AllArgsConstructor
public class Grill implements Cooking {

  private String name;

  @Override
  public void cook(Ingredient ingredient) {
    System.out.println("Готовится игредиент " + ingredient.getName() + " на девайсе " + name);
  }
}
