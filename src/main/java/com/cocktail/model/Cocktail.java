/**
 * 
 */
package com.cocktail.model;

import java.io.Serializable;
import java.time.Duration;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;

/**
 * The Class Cocktail.
 *
 * @author adelgo
 */

@Entity
public @Data class Cocktail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1450474630942694918L;
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The version. */
	@Version
	private Long version;

	/** The name. */
	String name;

	/** The rate. */
	// Rate from 0 to 10
	int rate;

	/** The description. */
	String description;

	/** The duration. */
	Duration duration;

//	/** The images. */
//	// TODO : should be saved as BLOB/CLOB not as string
//	List<String> images;

	/** The ingredients. */
	@OneToMany
	List<Ingredient> ingredients;

	/** The steps. */
	@OneToMany
	List<Step> steps;

}
