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

	public CocktailDTO getDTOFromCocktail(Cocktail cocktail){
		CocktailDTO cocktailDTO = new CocktailDTO();
		
		cocktailDTO.setDescription(cocktail.getDescription());
		cocktailDTO.setDuration(cocktail.getDuration());
		cocktailDTO.setImage(cocktail.getImage());
		cocktailDTO.setName(cocktail.getName());
		cocktailDTO.setRate(cocktail.getRate());
		
		return cocktailDTO;
	}
	
	public List<CocktailDTO> getDTOFromCocktails(Iterable<Cocktail> cocktails){
		List<CocktailDTO> cocktailDTOs = new ArrayList<>();
		
		//cocktails.forEach(cocktail -> cocktailDTOs.add(getDTOFromCocktail(cocktail)));
		cocktails.forEach(cocktail -> cocktailDTOs.add(modelMapper.map(cocktail, CocktailDTO.class)));
		
		return cocktailDTOs;
	}
	
}
