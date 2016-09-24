package com.cocktail.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

/**
 * The Class Ingredient.
 *
 * @author adelgo
 */

@Entity
public @Data class Ingredient implements Serializable {

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

}
