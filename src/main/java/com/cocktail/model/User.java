package com.cocktail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author adelgo
 *
 */

@Entity
public @Data class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String username;

	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
