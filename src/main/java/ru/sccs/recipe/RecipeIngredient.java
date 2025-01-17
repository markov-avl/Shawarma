package ru.sccs.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeIngredient {

    private String name;

    private Integer gram;
}
