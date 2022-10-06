package com.devmountain.skyrimAlchemyAppFinal.dtos;


import com.devmountain.skyrimAlchemyAppFinal.entities.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Serializable {

    private Long id;
    private String name;
    private String type;
    private String ingredient_1;
    private String ingredient_2;
    private String ingredient_3;
    private String effects;
    private Integer recipe_value;
    private UserDto userDto;

    public RecipeDto(Recipe recipe) {
        if (recipe.getId() != null) {
            this.id = recipe.getId();
        }
        if (recipe.getName() != null) {
            this.name = recipe.getName();
        }
        if (recipe.getType() != null) {
            this.type = recipe.getType();
        }
        if (recipe.getIngredient_1() != null) {
            this.ingredient_1 = recipe.getIngredient_1();
        }
        if (recipe.getIngredient_2() != null) {
            this.ingredient_2 = recipe.getIngredient_2();
        }
        if (recipe.getIngredient_3() != null) {
            this.ingredient_3 = recipe.getIngredient_3();
        }
        if (recipe.getEffects() != null) {
            this.effects = recipe.getEffects();
        }
        if (recipe.getRecipe_value() != null) {
            this.recipe_value = recipe.getRecipe_value();
        }

    }

}
