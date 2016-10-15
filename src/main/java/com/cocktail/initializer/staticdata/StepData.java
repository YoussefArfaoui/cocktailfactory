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
package com.cocktail.initializer.staticdata;

import com.cocktail.model.Step;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class StepData.
 *
 * @author arfaouiy
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new step data.
 *
 * @param step the step
 * @param cocktail the cocktail
 */
@AllArgsConstructor

/**
 * Instantiates a new step data.
 */
@NoArgsConstructor
public class StepData {
	
	/** The step. */
	private Step step;
	
	/** The cocktail. */
	private String cocktail;

}
