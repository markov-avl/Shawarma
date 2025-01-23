package ru.sccs.model.order;

import lombok.Data;
import ru.sccs.model.menu.MenuDish;
import ru.sccs.model.menu.MenuIngredient;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class OrderPosition {

    private final MenuDish dish;

    private final Integer quantity;

    private final Map<MenuIngredient, Integer> additionalIngredients;

    private final List<MenuIngredient> excludedIngredients;

}
