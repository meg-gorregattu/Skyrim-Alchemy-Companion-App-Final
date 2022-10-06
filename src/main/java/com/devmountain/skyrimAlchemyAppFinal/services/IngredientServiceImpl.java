package com.devmountain.skyrimAlchemyAppFinal.services;



import com.devmountain.skyrimAlchemyAppFinal.dtos.IngredientDto;
import com.devmountain.skyrimAlchemyAppFinal.entities.Ingredient;
import com.devmountain.skyrimAlchemyAppFinal.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    public List<IngredientDto> getAllIngredients() {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        return ingredientList.stream().map(ingredient -> new IngredientDto(ingredient)).collect(Collectors.toList());
    }
}