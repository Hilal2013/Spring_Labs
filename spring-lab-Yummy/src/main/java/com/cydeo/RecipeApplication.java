package com.cydeo;

import com.cydeo.model.Ingredients;
import com.cydeo.model.QuantityType;
import com.cydeo.model.Recipe;
import com.cydeo.model.RecipeType;
import com.cydeo.service.RecipeService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class RecipeApplication {

    public static void main(String[] args) {
        ApplicationContext container =    SpringApplication.run(RecipeApplication.class, args);
        Recipe recipe=new Recipe();
        recipe.setName("Blue Cheese Stuffed Tomatoes");
        recipe.setRecipeType(RecipeType.APPETIZER);
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
/*
  Ingredients ingredients1=new Ingredients();
        ingredients1.setName("Cream Cheese");
        ingredients1.setQuantity(BigDecimal.valueOf(2));
        ingredients1.setQuantityType(QuantityType.OUNCE);
recipe.setDuration("25 min");
recipe.setRecipeType(RecipeType.APPETIZER);
        System.out.println(recipe);
 */