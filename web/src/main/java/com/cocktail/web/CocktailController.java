package com.cocktail.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cocktail.services.CocktailService;

@Controller
@EnableAutoConfiguration
public class CocktailController {

	@Autowired
	private CocktailService cocktailService;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello Cocktail!";
	}

}