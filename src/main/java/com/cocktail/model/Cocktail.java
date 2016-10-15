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
import java.time.Duration;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Cocktail.
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
 * Instantiates a new cocktail.
 *
 * @param id
 *            the id
 * @param version
 *            the version
 * @param name
 *            the name
 * @param rate
 *            the rate
 * @param description
 *            the description
 * @param duration
 *            the duration
 * @param image
 *            the image
 * @param steps
 *            the steps
 * @param cocktailIngredients
 *            the cocktail ingredients
 */
@AllArgsConstructor
/**
 * Instantiates a new ingredient.
 */

/**
 * Instantiates a new ingredient.
 */

/**
 * Instantiates a new cocktail.
 */
@NoArgsConstructor
public class Cocktail implements Serializable {

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

	/** The image. */
	// TODO : should be saved as BLOB/CLOB not as string
	String image;

	/** The steps. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	List<Step> steps;

	/** The cocktail ingredients. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	List<CocktailIngredient> cocktailIngredients;

}
