package com.devmountain.skyrimAlchemyAppFinal.services;

import com.devmountain.skyrimAlchemyAppFinal.dtos.RecipeDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RecipeService {
    @Transactional
    void addRecipe(RecipeDto recipeDto, Long userId);

    @Transactional
    void deleteRecipeById(Long recipeId);

    @Transactional
    void updateRecipeById(RecipeDto recipeDto);

    List<RecipeDto> getAllRecipesByUserId(Long userId);

    Optional<RecipeDto> getRecipeById(Long recipeId);
}
