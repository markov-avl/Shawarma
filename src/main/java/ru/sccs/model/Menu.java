package ru.sccs.model;

import java.util.Map;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sccs.cooking.ingredient.Ingredient;

@Data
@RequiredArgsConstructor
public class Menu {

  private final Map<Shawarma, Double> shawarmaPrices;

  private final Map<Ingredient, Double> ingredientPrices;

  public void printShawarmaPrices() {
    System.out.println("----------------- Меню -----------------");
    if (shawarmaPrices == null || shawarmaPrices.isEmpty()) {
      System.out.println("No shawarma available.");
      return;
    }

    shawarmaPrices.forEach(
        (shawarma, price) -> System.out.printf("%-31s : %.2f\n", shawarma.getName(), price));
    System.out.println("----------------------------------------");
  }
}
