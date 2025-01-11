package ru.sccs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.sccs.cooking.ingredient.Ingredient;

@Data
@Accessors(chain = true)
public class OrderPosition {

  private Shawarma shawarma;
  private Integer quantity = 1;
  private Map<Ingredient, Integer> additionalIngredients = new HashMap<>();
  private List<Ingredient> excludedIngredients = new ArrayList<>();
}
