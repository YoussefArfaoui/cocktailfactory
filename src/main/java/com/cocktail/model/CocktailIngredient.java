package com.cocktail.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.Data;

/**
 * The Class CocktailIngredient.
 *
 * @author adelgo
 */

@Entity
public @Data class CocktailIngredient implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8375447618646909241L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The version. */
	@Version
	private Long version;
	/** The quantity. */
	BigDecimal quantity;

	/** The unit. */
	@Enumerated(EnumType.STRING)
	Unit unit;

	/** The optional. */
	boolean optional;

	/** The ingredient. */
	@OneToOne(optional = false)
	Ingredient ingredient;

}
