package ru.sccs.middleware;

import lombok.AllArgsConstructor;
import ru.sccs.actor.RecipeFormer;
import ru.sccs.command.PackShawarmaCommand;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.kitchen.mediator.Chef;
import ru.sccs.model.order.Order;

@AllArgsConstructor
public class CookingOrderMiddleware extends Middleware {

  private Chef chef;

  private KitchenFacade kitchenFacade;

  @Override
  protected boolean canHandle(Order order) {
    return order.getStatus().equals("Готовится");
  }

  @Override
  protected void process(Order order) {
    RecipeFormer.recipesOf(order).forEach((orderPosition, recipe) -> {
            recipe.getSteps().forEach(step -> chef.addCommand(step.getCommand()));
            chef.addCommand(new PackShawarmaCommand());

            System.out.printf("\nПриготовление '%s' в количестве %d шт.\n",
                    orderPosition.getDish().getName(), orderPosition.getQuantity());
            chef.prepareShawarma(kitchenFacade);
        });
    order.setStatus("Готов");
  }
}
