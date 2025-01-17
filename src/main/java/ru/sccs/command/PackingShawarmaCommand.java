package ru.sccs.command;

import ru.sccs.model.Shawarma;

// Команда для завертывания шаурмы
class PackingShawarmaCommand implements Command {
  private Shawarma shawarma;

  public PackingShawarmaCommand(Shawarma shawarma) {
    this.shawarma = shawarma;
  }

  @Override
  public void execute() {
    shawarma.wrap();
  }
}
