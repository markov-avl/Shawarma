package ru.sccs.model;

import lombok.AllArgsConstructor;
import ru.sccs.cooking.ingredient.Ingredient;

@AllArgsConstructor
public class RecipeIngredient {

    private Ingredient ingredient;

    private Double gram;
}
