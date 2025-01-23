package ru.sccs;

import ru.sccs.actor.Technologist;
import ru.sccs.actor.OrderManager;
import ru.sccs.kitchen.mediator.KitchenMediator;
import ru.sccs.model.menu.Menu;
import ru.sccs.model.order.Order;
import ru.sccs.observer.Client;

public class ShawarmaCookingControlSystem {

    public static void main(String[] args) {
        Menu menu = Technologist.createMenu();
        Technologist.printMenu(menu);

        OrderManager orderManager = new OrderManager(menu);
        Order order = orderManager.makeTestOrder();
        orderManager.printOrder(order);

        Client client = new Client();

        order.addObserver(client);

        KitchenMediator mediator = new KitchenMediator();
        mediator.cookOrder(order);
    }
}
