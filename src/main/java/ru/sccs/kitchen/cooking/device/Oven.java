package ru.sccs.kitchen.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.model.Ingredient;

/**
 * Печь
 */
@Data
@AllArgsConstructor
public class Oven implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(Ingredient ingredient) {
        System.out.printf("Запекается ингредиент '%s' в печи '%s'\n", ingredient, name);
        return new Ingredient("Запечен. " + ingredient);
    }

}
