package ru.sccs.mediator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.sccs.actor.RecipeFormer;
import ru.sccs.command.Chef;
import ru.sccs.command.Command;
import ru.sccs.cooking.device.CookingDevice;
import ru.sccs.factory.DeviceFactory;
import ru.sccs.model.Order;

@NoArgsConstructor
@AllArgsConstructor
public class ShawarmaMediator implements Mediator {

    private DeviceFactory deviceFactory = new DeviceFactory();

    private Chef chef = new Chef();

    public void cookShawarma(Order order) {
        RecipeFormer.recipesOf(order).forEach((orderPosition, recipe) -> {
            recipe.getSteps().forEach(step -> {
                CookingDevice device = deviceFactory.getFreeDevice(step.getDeviceType());
                Command command = step.getCommandMaker().apply(device);
                chef.addCommand(command);
            });
            chef.prepareShawarma();
        });
    }

    @Override
    public void packageShawarma() {

    }

    @Override
    public void packageOrder() {

    }
}
