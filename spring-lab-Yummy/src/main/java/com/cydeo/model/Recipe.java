package com.cydeo.model;

import java.util.List;
import java.util.UUID;

public class Recipe {
    private UUID id;
    private String name;
    private int duration;//cooking time
    private String preparation;
    private List<Ingredients> ingredients;
    private RecipeType recipeType;
}
