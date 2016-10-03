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
