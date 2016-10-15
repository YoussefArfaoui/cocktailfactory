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
package com.cocktail.services.impl;

import org.springframework.stereotype.Component;

import com.cocktail.model.Cocktail;
import com.cocktail.services.CocktailService;

/**
 * @author arfaouiy
 *
 */

@Component
public class CocktailServiceImpl implements CocktailService {

	@Override
	public Cocktail getCocktailById(Integer id) {
		return null;
	}

	@Override
	public Cocktail getCocktailByName(String name) {
		return null;
	}

}
