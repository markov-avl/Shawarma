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

    private static final Menu menu = Technologist.createMenu();

    private static final OrderManager orderManager = new OrderManager(menu);

    private static final OrderPrinter orderPrinter = new OrderPrinter(menu);

    private static final KitchenMediator kitchen = new KitchenMediator();

    public static void main(String[] args) {
        MenuPrinter.print(menu);

        Client client = new Client();
        Order order = orderManager.makeTestOrderFor(client);
        orderPrinter.print(order);

        kitchen.cookOrder(order);
    }
}
