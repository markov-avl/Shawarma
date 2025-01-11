package ru.sccs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sccs.cooking.ingredient.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
// TODO: pita?
public class Shawarma {

    private String name;

    private List<Ingredient> ingredients;

}
