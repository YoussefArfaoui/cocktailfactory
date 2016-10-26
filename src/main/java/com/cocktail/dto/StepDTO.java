package com.cocktail.dto;

import java.time.Duration;

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
public @Data class StepDTO {
	
	/** The name. */
	String name;

	/** The description. */
	String description;

	/** The order. */
	int orderNumber;


}
