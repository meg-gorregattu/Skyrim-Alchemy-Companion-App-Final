package com.devmountain.skyrimAlchemyAppFinal.services;

import com.devmountain.skyrimAlchemyAppFinal.dtos.IngredientDto;

import java.util.List;

public interface IngredientService {
    List<IngredientDto> getAllIngredients();
}
