package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Ingredient;

public interface IngredientReporitory extends CrudRepository<Ingredient, Long>{

	Ingredient findById(Long id);
	
}
