package ru.sccs.kitchen.cooking.strategy;

import ru.sccs.kitchen.cooking.DeviceFactory;
import ru.sccs.kitchen.cooking.device.CookingDevice;
import ru.sccs.kitchen.cooking.device.Grill;
import ru.sccs.kitchen.cooking.device.Pan;
import ru.sccs.model.Ingredient;

import java.util.Random;

public class FryingStrategy implements CookingStrategy {

    private final Random random = new Random();

    @Override
    public Ingredient cook(Ingredient ingredient) {
        CookingDevice device = random.nextBoolean()
                ? DeviceFactory.getFreeDevice(Pan.class)
                : DeviceFactory.getFreeDevice(Grill.class);

        return device.cook(ingredient);
    }

}
