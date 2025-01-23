package ru.sccs.model.order;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class OrderPosition {

    private MenuDish dish;
    private Integer quantity = 1;
    private Map<MenuIngredient, Integer> additionalIngredients = new HashMap<>();
    private List<MenuIngredient> excludedIngredients = new ArrayList<>();
}
