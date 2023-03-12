package com.cydeo.service;

import com.cydeo.config.AuthorConfigData;
import com.cydeo.model.Ingredients;
import com.cydeo.model.QuantityType;
import com.cydeo.model.Recipe;
import com.cydeo.proxy.ShareRecipeProxy;
import com.cydeo.repository.RecipeSaveRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RecipeServiceImpl implements RecipeService{
    private final ShareRecipeProxy shareRecipeProxy;
    private final RecipeSaveRepository recipeSaveRepository;

    private final Faker faker;
private final AuthorConfigData authorConfigData;
    public RecipeServiceImpl(AuthorConfigData dbRecipeConfigData, ShareRecipeProxy shareRecipeProxy, RecipeSaveRepository recipeSaveRepository, Faker faker) {
        this.authorConfigData = dbRecipeConfigData;
        this.shareRecipeProxy = shareRecipeProxy;
        this.recipeSaveRepository = recipeSaveRepository;
        this.faker = faker;
    }
  @Override
    public boolean prepareRecipe() {
      //create one Recipe object
      Recipe recipe = new Recipe();
      //set the fields
      recipe.setId(UUID.randomUUID());
      recipe.setName(faker.food().dish());
     recipe.setDuration(generateRandomValue());
      recipe.setPreparation(faker.lorem().paragraph(5));
      recipe.setIngredients(prepareIngredient());

        recipeSaveRepository.save(recipe);
        shareRecipeProxy.shareRecipe(recipe);
return true;
    }
public void printDbRecipeConfigData(){
    System.out.println(authorConfigData.getName());

}
    private List<Ingredients> prepareIngredient() {
        List<Ingredients> ingredientList = new ArrayList<>();


        for (int i = 0; i < generateRandomValue(); i++) {

            Ingredients ingredient = new Ingredients();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(QuantityType.TBSP);
            ingredientList.add(ingredient);

        }
        return ingredientList;
    }

    private int generateRandomValue() {
        return new Random().nextInt(20);
    }
}

