package ru.sccs.kitchen.cooking;

import ru.sccs.kitchen.cooking.device.Oven;
import ru.sccs.kitchen.cooking.device.Pan;
import ru.sccs.kitchen.cooking.device.Pot;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

public class KitchenFacade {

    private final DeviceFactory deviceFactory = new DeviceFactory();

    public Ingredient fry(RecipeIngredient ingredient) {
        Pan pan = deviceFactory.getFreeDevice(Pan.class);
        return pan.cook(ingredient);
    }

    public Ingredient bake(RecipeIngredient ingredient) {
        Oven oven = deviceFactory.getFreeDevice(Oven.class);
        return oven.cook(ingredient);
    }

    public Ingredient boil(RecipeIngredient ingredient) {
        Pot pot = deviceFactory.getFreeDevice(Pot.class);
        return pot.cook(ingredient);
    }

}
