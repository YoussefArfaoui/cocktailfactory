package com.cocktail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cocktail.dto.CocktailDTO;
import com.cocktail.services.CocktailService;

@RestController
public class CocktailController {

	@Autowired
	private CocktailService cocktailService;

	@RequestMapping(value = "/cocktail", method = RequestMethod.GET)
	public List<CocktailDTO> getCocktails(){		
		return cocktailService.getAllCocktails();
	}
	
}