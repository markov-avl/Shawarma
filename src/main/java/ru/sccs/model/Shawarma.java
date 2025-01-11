package ru.sccs.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;

@Data
@AllArgsConstructor
// TODO: pita?
public class Shawarma {

  private String name;
  private List<Ingredient> ingredients;
}
