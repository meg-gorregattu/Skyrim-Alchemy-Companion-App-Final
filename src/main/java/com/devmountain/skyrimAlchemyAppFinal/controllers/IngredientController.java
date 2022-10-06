package com.devmountain.skyrimAlchemyAppFinal.controllers;


import com.devmountain.skyrimAlchemyAppFinal.dtos.IngredientDto;
import com.devmountain.skyrimAlchemyAppFinal.entities.Ingredient;
import com.devmountain.skyrimAlchemyAppFinal.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ingredients")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public List<IngredientDto> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
}
