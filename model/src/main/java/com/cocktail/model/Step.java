package com.cocktail.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author adelgo
 *
 */

@Entity
public class Step {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	String name;
	
	String description;
	
	String order;
	
	@OneToMany
	List<Cocktail_Ingredient> cocktail_Ingredients;

	public Step() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<Cocktail_Ingredient> getCocktail_Ingredients() {
		return cocktail_Ingredients;
	}

	public void setCocktail_Ingredients(List<Cocktail_Ingredient> cocktail_Ingredients) {
		this.cocktail_Ingredients = cocktail_Ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cocktail_Ingredients == null) ? 0 : cocktail_Ingredients.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Step other = (Step) obj;
		if (cocktail_Ingredients == null) {
			if (other.cocktail_Ingredients != null)
				return false;
		} else if (!cocktail_Ingredients.equals(other.cocktail_Ingredients))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Step [id=" + id + ", name=" + name + ", description=" + description + ", order=" + order
				+ ", cocktail_Ingredients=" + cocktail_Ingredients + "]";
	}
	
}
