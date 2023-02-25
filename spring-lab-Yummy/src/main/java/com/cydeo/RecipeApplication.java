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


        RecipeService recipeService=container.getBean(RecipeService.class);
 //       recipeService.prepareRecipe();



    }

}
