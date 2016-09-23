package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Step;

public interface StepRepository extends CrudRepository<Step, Long>{

	Step findById(Long id);
}
