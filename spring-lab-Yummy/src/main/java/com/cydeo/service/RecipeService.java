package com.cydeo.service;

import com.cydeo.model.Recipe;
import com.cydeo.proxy.ShareRecipeProxy;
import com.cydeo.repository.RecipeSaveRepository;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeService {
    private final ShareRecipeProxy shareRecipeProxy;
    private final RecipeSaveRepository recipeSaveRepository;
    private final Faker faker;
    private final Random random;

    public RecipeService(ShareRecipeProxy shareRecipeProxy, RecipeSaveRepository recipeSaveRepository, Faker faker, Random random) {
        this.shareRecipeProxy = shareRecipeProxy;
        this.recipeSaveRepository = recipeSaveRepository;
        this.faker = faker;
        this.random = random;
    }


    public void prepareRecipe(Recipe recipe) {
        List<Recipe> list = new ArrayList<>();
        for (int i = 0; i < random.nextInt(list.size()); i++) {
            System.out.println(faker.food().ingredient());
        }


        recipeSaveRepository.save(recipe);
        shareRecipeProxy.shareRecipe(recipe);

    }


}
