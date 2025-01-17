package ru.sccs.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sccs.command.Command;

@Data
@AllArgsConstructor
public class Recipe {

  private String name;

  private List<RecipeIngredient> ingredients;

  private List<RecipeStep> steps;

  private Shawarma shawarma;

  public Recipe addStep(Command command) {
    shawarma.addIngredient();
    return this;
  }

  public Recipe() {
    shawarma = new Shawarma();
  }
}
