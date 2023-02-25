package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeRepository implements RecipeSaveRepository {
    @Override
    public void save(Recipe recipe) {
        System.out.println("Stored recipe" );
    }
}
