package ru.sccs.observer;

public class Client implements Observer {

    @Override
    public void update(String status) {
        System.out.println("Клиент уведомлен о том, что статус заказа изменился на " + status);
    }

}
