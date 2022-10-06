package com.devmountain.skyrimAlchemyAppFinal.controllers;

import com.devmountain.skyrimAlchemyAppFinal.dtos.RecipeDto;
import com.devmountain.skyrimAlchemyAppFinal.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/user/{userId}")
    public List<RecipeDto> getRecipesByUser(@PathVariable Long userId) {
        return recipeService.getAllRecipesByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addRecipe(@RequestBody RecipeDto recipeDto, @PathVariable Long userId){
        recipeService.addRecipe(recipeDto, userId);
    }

    @DeleteMapping("/{recipeId}")
    public void deleteRecipeById(@PathVariable Long recipeId){
        recipeService.deleteRecipeById(recipeId);
    }

    @PutMapping
    public void updateRecipe(@RequestBody RecipeDto recipeDto) {
        recipeService.updateRecipeById(recipeDto);
    }

    @GetMapping("/{recipeId}")
    public Optional<RecipeDto> getRecipeById(@PathVariable Long recipeId) {
        return recipeService.getRecipeById(recipeId);
    }
}
