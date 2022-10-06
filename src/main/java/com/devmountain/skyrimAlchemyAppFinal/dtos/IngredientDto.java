package com.devmountain.skyrimAlchemyAppFinal.dtos;


import com.devmountain.skyrimAlchemyAppFinal.entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto implements Serializable {

    private Long id;
    private String name;

    public IngredientDto(Ingredient ingredient){
        this.id = ingredient.getId();
        this.name = ingredient.getName();
    }
}
