package ru.sccs.kitchen.mediator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.sccs.actor.RecipeFormer;
import ru.sccs.command.PackShawarmaCommand;
import ru.sccs.kitchen.cooking.KitchenFacade;
import ru.sccs.middleware.CookingOrderMiddleware;
import ru.sccs.middleware.NewOrderMiddleware;
import ru.sccs.middleware.ReadyOrderMiddleware;
import ru.sccs.model.order.Order;

@AllArgsConstructor
public class KitchenMediator implements Mediator {

    private KitchenFacade kitchenFacade;

    private Chef chef;

    private Packer packer;

    public void cookOrder(Order order) {
        NewOrderMiddleware newOrderMiddleware = new NewOrderMiddleware();
        CookingOrderMiddleware cookingOrderMiddleware = new CookingOrderMiddleware(chef, kitchenFacade);
        ReadyOrderMiddleware readyOrderMiddleware = new ReadyOrderMiddleware(packer);

        newOrderMiddleware.setNext(cookingOrderMiddleware);
        cookingOrderMiddleware.setNext(readyOrderMiddleware);

        newOrderMiddleware.handle(order);
    }
}
