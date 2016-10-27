package com.cocktail.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cocktail.dto.CocktailDTO;
import com.cocktail.model.Cocktail;

@Component
public class CocktailMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CocktailDTO> getDTOFromCocktails(Iterable<Cocktail> cocktails){
		List<CocktailDTO> cocktailDTOs = new ArrayList<>();
		
		cocktails.forEach(cocktail -> cocktailDTOs.add(modelMapper.map(cocktail, CocktailDTO.class)));
		
		return cocktailDTOs;
	}
	
	public Cocktail getCocktailFromCocktailDTO(CocktailDTO cocktailDTO){
		return modelMapper.map(cocktailDTO, Cocktail.class);
	}
	
}
