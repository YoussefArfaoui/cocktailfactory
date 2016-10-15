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
package com.cocktail.repository;

import java.time.Duration;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Cocktail;

/**
 * The Interface CocktailRepository.
 */
public interface CocktailRepository extends CrudRepository<Cocktail, Long> {

	/**
	 * Find by name.
	 *
	 * @param name
	 *            the name
	 * @return the cocktail
	 */
	Cocktail findByName(String name);

	/**
	 * Find by rate.
	 *
	 * @param rate
	 *            the rate
	 * @return the list
	 */
	List<Cocktail> findByRate(int rate);

	/**
	 * Find by duration.
	 *
	 * @param duration
	 *            the duration
	 * @return the list
	 */
	List<Cocktail> findByDuration(Duration duration);

}
