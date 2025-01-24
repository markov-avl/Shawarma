package ru.sccs.printer;

import lombok.RequiredArgsConstructor;
import ru.sccs.model.menu.Menu;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.model.order.Order;
import ru.sccs.model.order.OrderPosition;
import ru.sccs.visitor.CostCalculatorOrderVisitor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class OrderPrinter {

    private final CostCalculatorOrderVisitor costCalculator;

    public OrderPrinter(Menu menu) {
        this.costCalculator = new CostCalculatorOrderVisitor(menu);
    }

    public void print(Order order) {
        if (order.getPositions() == null || order.getPositions().isEmpty()) {
            System.out.println("Заказ пуст");
            return;
        }

        List<String> positions = IntStream.range(0, order.getPositions().size())
                .mapToObj(i -> "%d. %s".formatted(i + 1, stringifyPosition(order.getPositions().get(i))))
                .toList();
        int maxLineLength = positions.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow();

        System.out.println("-".repeat(maxLineLength / 2 - 3) + " Заказ " + "-".repeat(maxLineLength / 2 - 3));
        positions.forEach(System.out::println);
        System.out.printf("Итоговая стоимость заказа: %.2f\n", costCalculator.visit(order));
        System.out.println("-".repeat(maxLineLength));
    }

    public String stringifyPosition(OrderPosition position) {
        String addedIngredients = position.getAdditionalIngredients().entrySet().stream()
                .filter(e -> !position.getExcludedIngredients().contains(e.getKey()))
                .map(e -> "%s x%d".formatted(e.getKey().getName(), e.getValue()))
                .collect(Collectors.joining(", "));
        String removedIngredients = position.getExcludedIngredients().stream()
                .map(MenuIngredient::getName)
                .collect(Collectors.joining(", "));

        StringBuilder sb = new StringBuilder();
        sb.append(position.getDish().getName()).append(" x").append(position.getQuantity());
        if (!addedIngredients.isEmpty()) {
            sb.append(" [+ ").append(addedIngredients).append("]");
        }
        if (!removedIngredients.isEmpty()) {
            sb.append(" [- ").append(removedIngredients).append("]");
        }
        sb.append(" -> Цена: %.2f".formatted(costCalculator.visit(position)));

        return sb.toString();
    }

}
