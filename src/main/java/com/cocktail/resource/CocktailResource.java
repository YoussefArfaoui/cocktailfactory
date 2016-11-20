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

import java.time.Duration;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author adelgo
 *
 */

public class CocktailResource extends ResourceSupport{

	/** The id  */
	Long id;
	
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
	String image;
	
	/** The steps. */
	List<StepResource> stepDTOs;
	
	/** The ingredients. */
	List<IngredientResource> ingredientDTOs;

	
	
}
