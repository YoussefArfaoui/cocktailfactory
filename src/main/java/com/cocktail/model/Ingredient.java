package com.cocktail.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Ingredient.
 *
 * @author adelgo
 */

@Entity
public 
 /* (non-Javadoc)
  * @see java.lang.Object#toString()
  */
 @Data 
 /**
  * Instantiates a new ingredient.
  *
  * @param id the id
  * @param version the version
  * @param name the name
  * @param description the description
  * @param image the image
  * @param type the type
  */
 @AllArgsConstructor 
 /**
  * Instantiates a new ingredient.
  */
 @NoArgsConstructor class Ingredient implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5240636132790489812L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The version. */
	@Version
	private Long version;

	/** The name. */
	String name;

	/** The description. */
	String description;

	/** The image. */
	// TODO : need to be BLOB
	String image;
	
	/** The type. */
	@Enumerated(EnumType.STRING)
	IngredientType type;

}
