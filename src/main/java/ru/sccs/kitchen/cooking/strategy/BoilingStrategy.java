package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.kitchen.cooking.device.Pot;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

public class BoilingStrategy implements CookingStrategy {

    @Override
    public Ingredient cook(DeviceFactory deviceFactory, RecipeIngredient ingredient) {
        Pot pot = deviceFactory.getFreeDevice(Pot.class);
        return pot.cook(ingredient);
    }

}
