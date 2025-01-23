package ru.sccs.kitchen.cooking;

import ru.sccs.kitchen.cooking.strategy.BakingStrategy;
import ru.sccs.kitchen.cooking.strategy.BoilingStrategy;
import ru.sccs.kitchen.cooking.strategy.FryingStrategy;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

public class KitchenFacade {

    private final DeviceFactory deviceFactory = new DeviceFactory();

    private final FryingStrategy fryingStrategy = new FryingStrategy();

    private final BakingStrategy bakingStrategy = new BakingStrategy();

    private final BoilingStrategy boilingStrategy = new BoilingStrategy();

    public Ingredient fry(RecipeIngredient ingredient) {
        return fryingStrategy.cook(deviceFactory, ingredient);
    }

    public Ingredient bake(RecipeIngredient ingredient) {
        return bakingStrategy.cook(deviceFactory, ingredient);
    }

    public Ingredient boil(RecipeIngredient ingredient) {
        return boilingStrategy.cook(deviceFactory, ingredient);
    }

}
