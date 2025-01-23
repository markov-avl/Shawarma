package ru.sccs.model.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sccs.model.menu.MenuIngredient;
import ru.sccs.observer.Observer;
import ru.sccs.visitor.CostCalculatorOrderVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class Order {

    private final List<OrderPosition> positions;

    private List<Observer> observers = new ArrayList<>();

    private String status = "NEW"; // Текущий статус заказа

    // Уведомление всех наблюдателей
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    // Установка статуса и уведомление наблюдателей
    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void print(CostCalculatorOrderVisitor calculator) {
        if (positions == null || positions.isEmpty()) {
            System.out.println("Заказ пуст");
            return;
        }

        System.out.println("--- Заказ ---");
        int index = 1;

        for (OrderPosition position : positions) {
            String addedIngredients = position.getAdditionalIngredients().entrySet().stream()
                    .map(e -> e.getKey().getName() + " x" + e.getValue())
                    .collect(Collectors.joining(", "));
            String removedIngredients = position.getExcludedIngredients().stream()
                    .map(MenuIngredient::getName)
                    .collect(Collectors.joining(", "));

            System.out.printf("%d. %s x%d", index++, position.getDish().getName(), position.getQuantity());
            if (!addedIngredients.isEmpty()) {
                System.out.printf(" [+ %s]", addedIngredients);
            }
            if (!removedIngredients.isEmpty()) {
                System.out.printf(" [- %s]", removedIngredients);
            }
            System.out.printf(" -> Цена: %.2f\n", calculator.visit(position));
        }
        System.out.println("----------------------");
        System.out.printf("Итоговая стоимость заказа: %.2f\n", calculator.visit(this));
    }

}
