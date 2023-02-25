package com.cydeo.service;

import com.cydeo.config.DBRecipeConfigData;
import com.cydeo.model.Recipe;
import com.cydeo.proxy.ShareRecipeProxy;
import com.cydeo.repository.RecipeSaveRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class RecipeService {
    private final ShareRecipeProxy shareRecipeProxy;
    private final RecipeSaveRepository recipeSaveRepository;
  //  private final Faker faker;
  //  private final Random random;
private final DBRecipeConfigData dbRecipeConfigData;
    public RecipeService(ShareRecipeProxy shareRecipeProxy, RecipeSaveRepository recipeSaveRepository, DBRecipeConfigData dbRecipeConfigData) {
        this.dbRecipeConfigData = dbRecipeConfigData;
        this.shareRecipeProxy = shareRecipeProxy;
        this.recipeSaveRepository = recipeSaveRepository;

    }

    public void prepareRecipe(Recipe recipe) {
        List<Recipe> list = new ArrayList<>();
        Faker faker=new Faker();
        Random random=new Random();
        for (int i = 0; i < random.nextInt(list.size()); i++) {
            System.out.println(faker.food().ingredient());
        }

        recipeSaveRepository.save(recipe);
        shareRecipeProxy.shareRecipe(recipe);

    }
public void printDbRecipeConfigData(){
    System.out.println();

}


}
