package ru.sccs.model.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sccs.observer.Observer;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {

    private final List<OrderPosition> positions;

    private List<Observer> observers = new ArrayList<>();

    private String status = "Новый"; // Текущий статус заказа

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

}
