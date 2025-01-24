package ru.sccs.kitchen.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.model.Ingredient;

/**
 * Кастрюля
 */
@Data
@AllArgsConstructor
public class Pot implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(Ingredient ingredient) {
        System.out.printf("Варится ингредиент '%s' в кастрюле '%s'\n", ingredient, name);
        return new Ingredient("Варен. " + ingredient);
    }

}
