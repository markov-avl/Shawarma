package ru.sccs.model;

import java.util.ArrayList;
import ru.sccs.cooking.ingredient.Ingredient;


public class Recipe {

  private String name;
  private ArrayList<RecipeIngredient> ingredients;
  private ArrayList<?> steps;
}
