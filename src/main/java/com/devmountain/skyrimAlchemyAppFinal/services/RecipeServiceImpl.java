package com.devmountain.skyrimAlchemyAppFinal.services;

import com.devmountain.skyrimAlchemyAppFinal.dtos.RecipeDto;
import com.devmountain.skyrimAlchemyAppFinal.entities.Recipe;
import com.devmountain.skyrimAlchemyAppFinal.entities.User;
import com.devmountain.skyrimAlchemyAppFinal.repositories.RecipeRepository;
import com.devmountain.skyrimAlchemyAppFinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void addRecipe(RecipeDto recipeDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Recipe recipe = new Recipe(recipeDto);
        userOptional.ifPresent(recipe::setUser);
        recipeRepository.saveAndFlush(recipe);
    }

    @Override
    @Transactional
    public void deleteRecipeById(Long recipeId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        recipeOptional.ifPresent(recipe -> recipeRepository.delete(recipe));
    }

    @Override
    @Transactional
    public void updateRecipeById(RecipeDto recipeDto) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeDto.getId());
        recipeOptional.ifPresent(recipe -> {
            recipe.setName(recipeDto.getName());
            recipe.setType(recipeDto.getType());
            recipe.setIngredient_1(recipeDto.getIngredient_1());
            recipe.setIngredient_2(recipeDto.getIngredient_2());
            recipe.setIngredient_3(recipeDto.getIngredient_3());
            recipe.setEffects(recipeDto.getEffects());
            recipe.setRecipe_value(recipeDto.getRecipe_value());
            recipeRepository.saveAndFlush(recipe);
        });
    }

    @Override
    public List<RecipeDto> getAllRecipesByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Recipe> recipeList = recipeRepository.findAllByUserEquals(userOptional.get());
            return recipeList.stream().map(recipe -> new RecipeDto(recipe)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<RecipeDto> getRecipeById(Long recipeId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (recipeOptional.isPresent()){
            return Optional.of(new RecipeDto(recipeOptional.get()));
        }
        return Optional.empty();
    }

}
