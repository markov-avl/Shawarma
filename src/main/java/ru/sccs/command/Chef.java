package ru.sccs.command;

import java.util.ArrayList;
import java.util.List;

// Invoker
public class Chef {
  private List<Command> commands = new ArrayList<>();

  public void addCommand(Command command) {
    commands.add(command);
  }

  public void prepareShawarma() {
    for (Command command : commands) {
      command.execute();
    }
    commands.clear(); // Очистка списка команд после выполнения
  }
}
