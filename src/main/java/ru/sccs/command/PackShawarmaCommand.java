package ru.sccs.command;

// Команда для завертывания шаурмы
public class PackShawarmaCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Заворачиваем всё в лаваш...");
    }
}
