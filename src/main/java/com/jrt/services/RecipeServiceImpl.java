package com.jrt.services;

import com.jrt.domain.Recipe;
import com.jrt.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if(!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Nor Found!");
        }

        return recipeOptional.get();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {

        Recipe savedRecipe = recipeRepository.save(recipe);

        return savedRecipe;
    }
}
