package ru.sccs.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// TODO: pita?
public class Shawarma {

  private String name;
  private List<Ingredient> ingredients;

  public void addIngredient(Ingredient ingredient) {
    ingredients.add(ingredient);
    System.out.println("Добавлен ингредиент: " + ingredient.getName());
  }

  public void wrap() {
    System.out.println("Шаурма " + name + " завернута!");
  }
}
