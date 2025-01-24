package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.kitchen.cooking.device.Pot;
import ru.sccs.model.Ingredient;

public class BoilingStrategy implements CookingStrategy {

    @Override
    public Ingredient cook(Ingredient ingredient) {
        Pot pot = DeviceFactory.getFreeDevice(Pot.class);
        return pot.cook(ingredient);
    }

}
