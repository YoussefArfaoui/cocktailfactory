/**
 * 
 */
package com.cocktail.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cocktail.dto.CocktailDTO;
import com.cocktail.model.Cocktail;
import com.cocktail.repository.CocktailRepository;
import com.cocktail.services.CocktailMapper;
import com.cocktail.services.CocktailService;

/**
 * @author arfaouiy
 *
 */

@Component
public class CocktailServiceImpl implements CocktailService {

	@Resource
	CocktailRepository cocktailRepository;
	
	@Resource
	CocktailMapper cocktailMapper;
	
	public List<CocktailDTO> getAllCocktails(){
		
		return cocktailMapper.getDTOFromCocktails(cocktailRepository.findAll());
	}
	
	@Override
	public Cocktail getCocktailById(Integer id) {
		return null;
	}

	@Override
	public Cocktail getCocktailByName(String name) {
		return null;
	}

}
