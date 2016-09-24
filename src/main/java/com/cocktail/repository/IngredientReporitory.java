package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Ingredient;

/**
 * The Interface IngredientReporitory.
 */
public interface IngredientReporitory extends CrudRepository<Ingredient, Long> {

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the ingredient
	 */
	Ingredient findById(Long id);

}
