package ru.sccs.command;

import ru.sccs.kitchen.cooking.KitchenFacade;

import java.util.ArrayList;
import java.util.List;

// Invoker
public class Chef {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void prepareShawarma(KitchenFacade kitchenFacade) {
        for (Command command : commands) {
            command.execute(kitchenFacade);
        }
        commands.clear();
    }
}
