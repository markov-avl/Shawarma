package ru.sccs.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;

/**
 * Кастрюля
 */
@Data
@AllArgsConstructor
public class Pan implements CookingDevice {

  private String name;

  @Override
  public void cook(Ingredient ingredient) {
    System.out.println("Варится игредиент " + ingredient.getName() + " на девайсе " + name);
  }
}
