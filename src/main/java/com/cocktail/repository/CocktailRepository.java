package com.cocktail.repository;

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

}
