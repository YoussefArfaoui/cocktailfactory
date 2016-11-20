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
package com.cocktail.resource;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;


/**
 * 
 * @author adelgo
 *
 */

public class IngredientResource extends ResourceSupport{

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
