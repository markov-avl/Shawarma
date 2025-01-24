package ru.sccs.kitchen.cooking.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.model.Ingredient;

/**
 * Сковорода
 */
@Data
@AllArgsConstructor
public class Pan implements CookingDevice {

    private String name;

    @Override
    public Ingredient cook(Ingredient ingredient) {
        System.out.printf("Жарится ингредиент '%s' на сковороде '%s'\n", ingredient, name);
        return new Ingredient("Жарен." + ingredient);
    }

}
