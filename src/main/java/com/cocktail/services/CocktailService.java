/*
 * Copyright Adel Ghoulem && Youssef Arfaoui
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
	
	/**
	 * Get all cocktails
	 * 
	 * @return cocktail list
	 */
	List<CocktailDTO> getAllCocktails();
	
	/**
	 * Add new cocktail
	 * 
	 * @param cocktailDTO
	 * @return Cocktail
	 */
	Cocktail addCocktail(CocktailDTO cocktailDTO);
	
	/**
	 * Get cocktail by Id
	 * 
	 * @param id
	 *            the cocktail id
	 * @return the cocktail
	 */
	CocktailDTO getCocktailById(String id);

	/**
	 * Get cocktail by name
	 * 
	 * @param name
	 *            the cocktail name
	 * @return the cocktail DTO
	 */
	Cocktail getCocktailByName(String name);

}
