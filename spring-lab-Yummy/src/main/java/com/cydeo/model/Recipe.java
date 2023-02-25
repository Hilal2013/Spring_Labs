package com.cydeo.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class Recipe {
    private UUID id;
    private String name;
    private String duration;//cooking time
    private String preparation;
    private List<Ingredients> ingredients;
    private RecipeType recipeType;
}
