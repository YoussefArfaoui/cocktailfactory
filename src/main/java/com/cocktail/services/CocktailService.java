package com.cocktail.services;

import com.cocktail.model.Cocktail;

/**
 * Cocktail Service
 * 
 * @author arfaouiy
 *
 */
public interface CocktailService {
	/**
	 * Get cocktail by Id
	 * 
	 * @param id
	 *            the cocktail id
	 * @return the cocktail
	 */
	Cocktail getCocktailById(Integer id);

	/**
	 * Get cocktail by name
	 * 
	 * @param name
	 *            the cocktail name
	 * @return the cocktail
	 */
	Cocktail getCocktailByName(String name);

}
