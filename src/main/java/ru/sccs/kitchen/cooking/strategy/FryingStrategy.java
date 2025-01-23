package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.kitchen.cooking.device.CookingDevice;
import ru.sccs.kitchen.cooking.device.Grill;
import ru.sccs.kitchen.cooking.device.Pan;
import ru.sccs.model.Ingredient;
import ru.sccs.model.recipe.RecipeIngredient;

import java.util.Random;

public class FryingStrategy implements CookingStrategy {

    private final Random random = new Random();

    @Override
    public Ingredient cook(DeviceFactory deviceFactory, RecipeIngredient ingredient) {
        CookingDevice device = random.nextBoolean()
                ? deviceFactory.getFreeDevice(Pan.class)
                : deviceFactory.getFreeDevice(Grill.class);

        return device.cook(ingredient);
    }

}
