package ru.sccs.command;

import ru.sccs.kitchen.cooking.KitchenFacade;

public interface Command {

    void execute(KitchenFacade kitchenFacade);
}
