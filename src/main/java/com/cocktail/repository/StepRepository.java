package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Step;

/**
 * The Interface StepRepository.
 */
public interface StepRepository extends CrudRepository<Step, Long> {

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the step
	 */
	Step findById(Long id);
}
