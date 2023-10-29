package com.Anvesh.Recipemanagementsystem.repository;

import com.Anvesh.Recipemanagementsystem.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepo extends JpaRepository<Recipe, Long> {
}
