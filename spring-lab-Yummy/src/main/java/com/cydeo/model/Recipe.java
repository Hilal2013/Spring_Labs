package com.cydeo.model;

import com.cydeo.RecipeType;

import java.util.UUID;

public class Recipe {
    private UUID id;
    private String name;
    private int duration;//cooking time
    private String preparation;
    private Ingredients ingredients;
    private RecipeType recipeType;
}
