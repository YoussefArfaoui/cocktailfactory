package com.cocktail.repository;

import org.springframework.data.repository.CrudRepository;

import com.cocktail.model.User;

/**
 * 
 * @author adelgo
 *
 */

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);
	
}
