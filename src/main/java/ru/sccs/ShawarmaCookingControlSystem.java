package ru.sccs;

import ru.sccs.actor.Technologist;
import ru.sccs.actor.OrderManager;
import ru.sccs.kitchen.mediator.KitchenMediator;
import ru.sccs.model.menu.Menu;
import ru.sccs.model.order.Order;
import ru.sccs.observer.Client;
import ru.sccs.printer.MenuPrinter;
import ru.sccs.printer.OrderPrinter;

public class ShawarmaCookingControlSystem {

    public static void main(String[] args) {
        Menu menu = Technologist.createMenu();
        MenuPrinter.print(menu);

        Client client = new Client();
        OrderManager orderManager = new OrderManager(menu);
        OrderPrinter orderPrinter = new OrderPrinter(menu);

        Order order = orderManager.makeTestOrder();
        orderPrinter.print(order);
        order.addObserver(client);

        KitchenMediator mediator = new KitchenMediator();
        mediator.cookOrder(order);
    }
}
