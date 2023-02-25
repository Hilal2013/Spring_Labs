package com.cydeo.proxy;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class InstagramShareProxy implements ShareRecipeProxy {
    @Override
    public void shareRecipe(Recipe recipe) {
        System.out.println("Recipe on Instagram: " + recipe.getName());
    }
}
