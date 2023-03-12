package com.cydeo.service;

import com.cydeo.config.DBRecipeConfigData;
import com.cydeo.model.Recipe;
import com.cydeo.proxy.ShareRecipeProxy;
import com.cydeo.repository.RecipeSaveRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeServiceImpl implements RecipeService{
    private final ShareRecipeProxy shareRecipeProxy;
    private final RecipeSaveRepository recipeSaveRepository;

private final DBRecipeConfigData dbRecipeConfigData;
    public RecipeServiceImpl(DBRecipeConfigData dbRecipeConfigData, ShareRecipeProxy shareRecipeProxy, RecipeSaveRepository recipeSaveRepository) {
        this.dbRecipeConfigData = dbRecipeConfigData;
        this.shareRecipeProxy = shareRecipeProxy;
        this.recipeSaveRepository = recipeSaveRepository;

    }
  @Override
    public void prepareRecipe(Recipe recipe) {
        List<Recipe> list = new ArrayList<>();
        Faker faker=new Faker();
      //  Random random=new Random();
        for (int i = 0; i <5; i++) {
            System.out.println(faker.food().ingredient());
        }

        recipeSaveRepository.save(recipe);
        shareRecipeProxy.shareRecipe(recipe);

    }
public void printDbRecipeConfigData(){
    System.out.println(dbRecipeConfigData.getName());

}



}
