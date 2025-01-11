package ru.sccs.visitor;

import ru.sccs.model.Menu;
import ru.sccs.model.OrderPosition;
import ru.sccs.model.Shawarma;

public class PriceCalculator implements Visitor {
  private final Menu menu;

  public PriceCalculator(Menu menu) {
    this.menu = menu;
  }

  @Override
  public double visit(OrderPosition position) {
    Shawarma shawarma = position.getShawarma();
    double basePrice = menu.getShawarmaPrices().getOrDefault(shawarma, 0.0);

    double additionalPrice = position.getAdditionalIngredients().entrySet().stream()
        .mapToDouble(entry -> menu.getIngredientPrices().getOrDefault(entry.getKey(), 0.0) * entry.getValue())
        .sum();

    double excludedPrice = position.getExcludedIngredients().stream()
        .mapToDouble(ingredient -> menu.getIngredientPrices().getOrDefault(ingredient, 0.0))
        .sum();

    return (basePrice + additionalPrice - excludedPrice) * position.getQuantity();
  }
}
