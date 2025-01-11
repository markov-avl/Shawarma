package ru.sccs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sccs.cooking.ingredient.Ingredient;
import ru.sccs.visitor.Visitor;

@Data
@NoArgsConstructor
public class Order {

  private List<OrderPosition> positions = new ArrayList<>();

  public Order(List<OrderPosition> positions) {
    this.positions = new ArrayList<>(positions);
  }

  public Order addPosition(OrderPosition position) {
    positions.add(position);
    return this;
  }

  public Order removePosition(int position) {
    positions.remove(position);
    return this;
  }

  public void print(Visitor visitor) {
    if (positions == null || positions.isEmpty()) {
      System.out.println("Заказ пуст");
      return;
    }

    System.out.println("--- Заказ ---");
    int index = 1;
    double totalCost = 0;
    for (OrderPosition position : positions) {
      String addedIngredients = position.getAdditionalIngredients().entrySet().stream()
          .map(e -> e.getKey().getName() + " x" + e.getValue())
          .collect(Collectors.joining(", "));
      String removedIngredients = position.getExcludedIngredients().stream()
          .map(Ingredient::getName)
          .collect(Collectors.joining(", "));

      double price = visitor.visit(position);
      totalCost += price;

      System.out.printf("%d. %s x%d", index++, position.getShawarma().getName(),
          position.getQuantity());
      if (!addedIngredients.isEmpty()) {
        System.out.printf(" [+ %s]", addedIngredients);
      }
      if (!removedIngredients.isEmpty()) {
        System.out.printf(" [- %s]", removedIngredients);
      }
      System.out.printf(" -> Цена: %.2f\n", price);
    }
    System.out.println("----------------------");
    System.out.printf("Итоговая стоимость заказа: %.2f\n", totalCost);
  }
}
