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
package com.cocktail.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CocktailIngredient.
 *
 * @author adelgo
 */

@Entity

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new cocktail ingredient.
 *
 * @param id
 *            the id
 * @param version
 *            the version
 * @param quantity
 *            the quantity
 * @param unit
 *            the unit
 * @param optional
 *            the optional
 * @param ingredient
 *            the ingredient
 */
@AllArgsConstructor
/**
 * Instantiates a new ingredient.
 */

/**
 * Instantiates a new ingredient.
 */

/**
 * Instantiates a new cocktail ingredient.
 */
@NoArgsConstructor
public class CocktailIngredient implements Serializable {

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
	  @ManyToOne(fetch = FetchType.EAGER)
	Ingredient ingredient;

}
