package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Cocktail_Ingredient;

public interface Cocktail_IngredientRepository extends CrudRepository<Cocktail_Ingredient, Long>{

	Cocktail_Ingredient findById(Long id);
	
}
