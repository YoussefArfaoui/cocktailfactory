package com.cocktail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cocktail.services.CocktailService;

@Controller
public class CocktailController {

	@Autowired
	private CocktailService cocktailService;

	@RequestMapping("/home")
	@ResponseBody
	String home() {
		return "Hello Cocktail!";
	}

}