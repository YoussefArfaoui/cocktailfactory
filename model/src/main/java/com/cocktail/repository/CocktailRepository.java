package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.Cocktail;

public interface CocktailRepository extends CrudRepository<Cocktail, Long> {

	Cocktail findById(Long id);
	
}
