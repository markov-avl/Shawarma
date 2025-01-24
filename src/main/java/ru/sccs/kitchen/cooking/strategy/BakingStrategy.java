package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.kitchen.cooking.device.Oven;
import ru.sccs.model.Ingredient;

public class BakingStrategy implements CookingStrategy {

    @Override
    public Ingredient cook(Ingredient ingredient) {
        Oven oven = DeviceFactory.getFreeDevice(Oven.class);
        return oven.cook(ingredient);
    }

}
