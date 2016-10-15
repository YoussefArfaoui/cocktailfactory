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

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data
/**
 * Instantiates a new ingredient.
 *
 * @param id
 *            the id
 * @param version
 *            the version
 * @param name
 *            the name
 * @param description
 *            the description
 * @param image
 *            the image
 * @param type
 *            the type
 */

/**
 * Instantiates a new ingredient.
 *
 * @param id
 *            the id
 * @param version
 *            the version
 * @param name
 *            the name
 * @param description
 *            the description
 * @param image
 *            the image
 * @param type
 *            the type
 */
@AllArgsConstructor
/**
 * Instantiates a new ingredient.
 */

/**
 * Instantiates a new ingredient.
 */
@NoArgsConstructor
public class Ingredient implements Serializable {

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
