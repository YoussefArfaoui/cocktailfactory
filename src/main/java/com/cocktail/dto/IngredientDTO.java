package com.cocktail.dto;

import java.math.BigDecimal;

/**
 * 
 * @author adelgo
 *
 */

public class IngredientDTO {

	/** The quantity. */
	BigDecimal quantity;

	/** The unit. */
	String unit;

	/** The optional. */
	boolean optional;
	
	/** The name. */
	String name;

	/** The description. */
	String description;

	/** The image. */
	// TODO : need to be BLOB
	String image;
	
	/** The type. */
	String type;
	
}
