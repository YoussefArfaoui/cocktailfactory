package com.cocktail.dto;

import java.time.Duration;
import java.util.List;

import com.cocktail.model.Cocktail;
import com.cocktail.model.CocktailIngredient;
import com.cocktail.model.Step;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author adelgo
 *
 */

@NoArgsConstructor
@AllArgsConstructor
public @Data class CocktailDTO {

	/** The name. */
	String name;

	/** The rate. */
	// Rate from 0 to 10
	int rate;

	/** The description. */
	String description;

	/** The duration. */
	Duration duration;

	/** The image. */
	String image;
	
	/** The steps. 
	List<StepDTO> stepDTOs;
	
	List<IngredientDTO> ingredientDTOs;*/

	
	
}
