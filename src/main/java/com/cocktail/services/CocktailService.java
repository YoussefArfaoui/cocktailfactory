package com.cocktail.services;

import java.util.List;

import com.cocktail.dto.CocktailDTO;
import com.cocktail.model.Cocktail;

/**
 * Cocktail Service
 * 
 * @author arfaouiy
 *
 */
public interface CocktailService {
	
	List<CocktailDTO> getAllCocktails();
	
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
