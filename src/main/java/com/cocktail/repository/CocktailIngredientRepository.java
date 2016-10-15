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
