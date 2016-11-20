package com.cocktail.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cocktail.model.Cocktail;
import com.cocktail.resource.CocktailResource;

@Component
public class CocktailMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CocktailResource> getDTOFromCocktails(Iterable<Cocktail> cocktails){
		List<CocktailResource> cocktailDTOs = new ArrayList<>();
		
		cocktails.forEach(cocktail -> cocktailDTOs.add(modelMapper.map(cocktail, CocktailResource.class)));
		
		return cocktailDTOs;
	}
	
	public Cocktail getCocktailFromCocktailDTO(CocktailResource cocktailDTO){
		return modelMapper.map(cocktailDTO, Cocktail.class);
	}
	
	public CocktailResource getCocktailDTOFromCocktail(Cocktail cocktail){
		return modelMapper.map(cocktail, CocktailResource.class);
	}
	
}
