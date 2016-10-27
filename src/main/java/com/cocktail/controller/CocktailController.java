/*
 * Copyright Adel Ghoulem && Youssef Arfaoui
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cocktail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cocktail.dto.CocktailDTO;
import com.cocktail.model.Cocktail;
import com.cocktail.services.CocktailService;

@RestController
public class CocktailController {

	@Autowired
	private CocktailService cocktailService;

	@RequestMapping(value = "/cocktails", method = RequestMethod.GET)
	public List<CocktailDTO> getCocktails(){		
		return cocktailService.getAllCocktails();
	}
	
	@RequestMapping(value = "/cocktails/cocktail", method = RequestMethod.POST)
	public ResponseEntity<?>  addCocktail(@RequestBody CocktailDTO cocktailDTO, UriComponentsBuilder ucBuilder){
		
		Cocktail cocktail = cocktailService.addCocktail(cocktailDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Cocktails/Cocktail/{id}").buildAndExpand(cocktail.getId()).toUri());
		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/cocktails/cocktail/", method = RequestMethod.GET)
	public CocktailDTO getCocktail(@PathVariable String id){
		
		return cocktailService.getCocktailById(id);
		
	}
	
}