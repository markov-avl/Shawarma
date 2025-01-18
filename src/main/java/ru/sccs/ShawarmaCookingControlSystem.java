package ru.sccs;

import ru.sccs.actor.Technologist;
import ru.sccs.actor.OrderManager;
import ru.sccs.mediator.ShawarmaMediator;
import ru.sccs.menu.Menu;
import ru.sccs.model.Order;
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

        ShawarmaMediator mediator = new ShawarmaMediator();
        mediator.cookOrder(order);
    }
}
