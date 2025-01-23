package ru.sccs.command;

import ru.sccs.kitchen.cooking.KitchenFacade;

// Команда для завертывания шаурмы
public class PackShawarmaCommand implements Command {

    @Override
    public void execute(KitchenFacade kitchenFacade) {
        System.out.println("Заворачиваем всё в лаваш...");
    }
}
