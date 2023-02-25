package com.cydeo.proxy;

import com.cydeo.model.Recipe;

public class InstagramShareProxy implements ShareRecipeProxy {
    @Override
    public void shareRecipe(Recipe recipe) {
        System.out.println("Recipe: " + recipe.toString());
    }
}
