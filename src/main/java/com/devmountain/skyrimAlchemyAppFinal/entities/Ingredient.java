package com.devmountain.skyrimAlchemyAppFinal.entities;


import com.devmountain.skyrimAlchemyAppFinal.dtos.IngredientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    public Ingredient(IngredientDto ingredientDto) {
            this.id = ingredientDto.getId();
            this.name = ingredientDto.getName();
    }

}
