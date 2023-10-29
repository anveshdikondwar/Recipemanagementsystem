package com.Anvesh.Recipemanagementsystem.repository;

import com.Anvesh.Recipemanagementsystem.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientsRepo extends JpaRepository<Ingredients,Long> {
}
