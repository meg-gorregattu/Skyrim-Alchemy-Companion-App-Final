package com.devmountain.skyrimAlchemyAppFinal.repositories;


import com.devmountain.skyrimAlchemyAppFinal.entities.Recipe;
import com.devmountain.skyrimAlchemyAppFinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByUserEquals(User user);
}
