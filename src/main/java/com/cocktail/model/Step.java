package com.cocktail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

/**
 * The Class Step.
 *
 * @author adelgo
 */

@Entity
public @Data class Step {

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

	/** The order. */
	int orderNumber;

}
