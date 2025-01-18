package ru.sccs.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor
public class MenuIngredient {

    // Название ингредиента блюда
    private final String name;
}
