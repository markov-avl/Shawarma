package ru.sccs.observer;

public class Client implements Observer{

  @Override
  public void update(String status) {
    System.out.println("Статус заказа изменился на " + status);
  }
}
