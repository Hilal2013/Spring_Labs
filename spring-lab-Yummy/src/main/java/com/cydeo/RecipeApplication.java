package com.cydeo;

import com.cydeo.model.Recipe;
import com.cydeo.service.RecipeService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class RecipeApplication {

    public static void main(String[] args) {
        ApplicationContext container =    SpringApplication.run(RecipeApplication.class, args);
        Recipe recipe=new Recipe();
recipe.setName("Baklava");
        RecipeService recipeService=container.getBean(RecipeService.class);
       recipeService.prepareRecipe(recipe);
//Bocconcini
//Rice Syrup
//Parmesan Cheese
//Spearmint
//Corella Pear
//Stored recipe
//Recipe on Facebook:Baklava
recipeService.printDbRecipeConfigData();//Chuck

    }

}
