package com.jrt.services;

import com.jrt.domain.Ingredient;

public interface IngredientService {

    Ingredient findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
