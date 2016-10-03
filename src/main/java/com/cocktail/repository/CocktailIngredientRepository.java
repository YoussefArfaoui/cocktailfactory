package com.cocktail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.CocktailIngredient;
import com.cocktail.model.Ingredient;

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

	/**
	 * Find by ingredient.
	 *
	 * @param ingredient
	 *            the ingredient
	 * @return the list
	 */
	List<CocktailIngredient> findByIngredient(Ingredient ingredient);

}
