package com.cSmithSwim.Cullenary.businessLayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.cSmithSwim.Cullenary.persistanceLayer.RecipeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe save(Recipe newRecipe) {
        return recipeRepository.save(newRecipe);
    }

    public Recipe findRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Recipe not found for id = " + id));
    }

    public void deleteRecipeById(Long id) {
        Recipe recipe = findRecipeById(id);
        recipeRepository.delete(recipe);
    }

    public void updateRecipe(Long id, Recipe recipe) {
        Recipe storedRecipe = findRecipeById(id);

        storedRecipe.setName(recipe.getName());
        storedRecipe.setCategory(recipe.getCategory());
        storedRecipe.setDescription(recipe.getDescription());
        storedRecipe.setIngredients(recipe.getIngredients());
        storedRecipe.setDirections(recipe.getDirections());
        storedRecipe.setDate(LocalDateTime.now());
        recipeRepository.save(storedRecipe);
    }

    public List<Recipe> searchRecipesBy(Map<String, String> allParams) {
        List<Recipe> recipes;
        if (allParams.size() > 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such params");
        String a;
        if (allParams.containsKey("name")) {
            a = "name";
            String param = allParams.get(a);
            recipes = recipeRepository.findByName(param);
        } else if (allParams.containsKey("category")) {
            a = "category";
            String param = allParams.get(a);
            recipes = recipeRepository.findByCategory(param);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such params");
        }
        return recipes;    }

}