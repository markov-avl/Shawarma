package ru.sccs.kitchen.cooking.device;

import ru.sccs.model.Ingredient;

public interface CookingDevice {

    Ingredient cook(Ingredient ingredient);

}
