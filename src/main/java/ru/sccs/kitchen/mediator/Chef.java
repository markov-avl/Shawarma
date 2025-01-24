package ru.sccs.kitchen.mediator;

import java.util.ArrayList;
import java.util.List;
import ru.sccs.command.Command;
import ru.sccs.kitchen.cooking.KitchenFacade;

// Invoker
public class Chef extends Colleague {

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
