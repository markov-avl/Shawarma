package ru.sccs.model.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private List<RecipeIngredient> ingredients;

    private List<RecipeStep> steps;
}
