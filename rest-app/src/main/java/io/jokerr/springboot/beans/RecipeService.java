package io.jokerr.springboot.beans;

import io.jokerr.springboot.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author jokerr
 */
@Service
public class RecipeService {

    public Recipe findRecipe(String recipeId) {
        Recipe recipe = new Recipe();
        recipe.setId(UUID.randomUUID().toString());
        recipe.setName("Bob");
        return recipe;
    }
}
