package com.devmountain.skyrimAlchemyAppFinal.repositories;


import antlr.collections.List;
import com.devmountain.skyrimAlchemyAppFinal.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
