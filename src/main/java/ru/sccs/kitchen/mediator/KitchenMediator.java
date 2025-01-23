package ru.sccs.kitchen.mediator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.sccs.actor.RecipeFormer;
import ru.sccs.command.Chef;
import ru.sccs.command.PackShawarmaCommand;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.model.order.Order;

@NoArgsConstructor
@AllArgsConstructor
public class KitchenMediator implements Mediator {

    private KitchenFacade kitchenFacade = new KitchenFacade();

    private Chef chef = new Chef();

    public void cookOrder(Order order) {
        order.setStatus("Готовится");
        RecipeFormer.recipesOf(order).forEach((orderPosition, recipe) -> {
            recipe.getSteps().forEach(step -> chef.addCommand(step.getCommand()));
            chef.addCommand(new PackShawarmaCommand());

            System.out.printf("\nПриготовление '%s' в количестве %d шт.\n",
                    orderPosition.getDish().getName(), orderPosition.getQuantity());
            chef.prepareShawarma(kitchenFacade);
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
