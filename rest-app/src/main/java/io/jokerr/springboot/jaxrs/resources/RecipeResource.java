package io.jokerr.springboot.jaxrs.resources;

import io.jokerr.springboot.beans.RecipeService;
import io.jokerr.springboot.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author jokerr
 */
@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {

    private RecipeService recipeService;

    @Autowired
    public RecipeResource(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GET
    @Path("{recipeId}")
    public Recipe getRecipe(@PathParam("recipeId") String recipeId) {
        return recipeService.findRecipe(recipeId);
    }
}
