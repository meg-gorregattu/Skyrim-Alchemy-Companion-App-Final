package com.devmountain.skyrimAlchemyAppFinal.entities;


import com.devmountain.skyrimAlchemyAppFinal.dtos.RecipeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "Recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String ingredient_1;

    @Column
    private String ingredient_2;

    @Column
    private String ingredient_3;

    @Column(columnDefinition = "text")
    private String effects;

    @Column
    private Integer recipe_value;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Recipe(RecipeDto recipeDto) {
        if (recipeDto.getName() != null) {
            this.name = recipeDto.getName();
        }
        if (recipeDto.getType() != null) {
            this.type = recipeDto.getType();
        }
        if (recipeDto.getIngredient_1() != null) {
            this.ingredient_1 = recipeDto.getIngredient_1();
        }
        if (recipeDto.getIngredient_2() != null) {
            this.ingredient_2 = recipeDto.getIngredient_2();
        }
        if (recipeDto.getIngredient_3() != null) {
            this.ingredient_3 = recipeDto.getIngredient_3();
        }
        if (recipeDto.getEffects() != null) {
            this.effects = recipeDto.getEffects();
        }
        if (recipeDto.getRecipe_value() != null) {
            this.recipe_value = recipeDto.getRecipe_value();
        }
    }
}
