package com.cydeo.proxy;

import com.cydeo.model.Recipe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FacebookShareProxy implements ShareRecipeProxy{
    @Override
    public void shareRecipe(Recipe recipe) {
        System.out.println("Recipe:" + recipe.toString());
    }
}
