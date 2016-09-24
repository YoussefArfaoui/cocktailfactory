package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.CocktailIngredient;

/**
 * The Interface CocktailIngredientRepository.
 */
public interface CocktailIngredientRepository extends CrudRepository<CocktailIngredient, Long> {

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the cocktail ingredient
	 */
	CocktailIngredient findById(Long id);

}
