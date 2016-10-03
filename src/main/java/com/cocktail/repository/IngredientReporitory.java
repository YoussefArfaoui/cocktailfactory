package com.cocktail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Ingredient;
import com.cocktail.model.IngredientType;

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

	/**
	 * Find by type.
	 *
	 * @param type
	 *            the type
	 * @return the list
	 */
	List<Ingredient> findByType(IngredientType type);

}
