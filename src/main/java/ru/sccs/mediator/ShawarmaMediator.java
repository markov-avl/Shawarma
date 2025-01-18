package ru.sccs.mediator;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.sccs.actor.RecipeFormer;
import ru.sccs.command.Chef;
import ru.sccs.command.Command;
import ru.sccs.command.PackShawarmaCommand;
import ru.sccs.factory.DeviceFactory;
import ru.sccs.model.Order;

@NoArgsConstructor
@AllArgsConstructor
public class ShawarmaMediator implements Mediator {

  private DeviceFactory deviceFactory = new DeviceFactory();

  private Chef chef = new Chef();

  public void cookOrder(Order order) {
    order.setStatus("Готовится");
    RecipeFormer.recipesOf(order).forEach((orderPosition, recipe) -> {
      recipe.getSteps().forEach(step -> {
        Command command = Optional.ofNullable(step.getDeviceType())
            .map(deviceFactory::getFreeDevice)
            .map(step.getCommandMaker())
            .orElse(step.getCommandMaker().apply(null));
        chef.addCommand(command);
      });

      chef.addCommand(new PackShawarmaCommand());

      System.out.printf("\nПриготовление '%s' в количестве %d шт.\n",
          orderPosition.getDish().getName(), orderPosition.getQuantity());
      chef.prepareShawarma();
    });
    order.setStatus("Готов");
  }

  @Override
  public void packageShawarma() {
  }

  @Override
  public void packageOrder() {
  }
}
