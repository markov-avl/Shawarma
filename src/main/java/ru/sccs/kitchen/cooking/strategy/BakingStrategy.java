package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.kitchen.cooking.device.Oven;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

public class BakingStrategy implements CookingStrategy {

    @Override
    public Ingredient cook(DeviceFactory deviceFactory, RecipeIngredient ingredient) {
        Oven oven = deviceFactory.getFreeDevice(Oven.class);
        return oven.cook(ingredient);
    }

}
