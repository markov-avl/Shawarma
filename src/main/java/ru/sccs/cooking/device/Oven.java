package ru.sccs.cooking.device;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;

/**
 * Печь
 */
@Data
@AllArgsConstructor
public class Oven implements CookingDevice {

  private String name;

  @Override
  public void cook(Ingredient ingredient) {
    System.out.println("Готовится игредиент " + ingredient.getName() + " на девайсе " + name);
  }
}
