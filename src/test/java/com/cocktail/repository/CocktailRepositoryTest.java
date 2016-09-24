package com.cocktail.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cocktail.model.Cocktail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CocktailRepositoryTest {

	@Autowired
	CocktailRepository cocktailRepository;

	@Before
	@After
	public void setUp() {
		cocktailRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		Cocktail cocktail = new Cocktail();
		cocktail.setName("Limonada");
		cocktail.setDescription("Limonada is a Tunisian cocktail");
		cocktail = cocktailRepository.save(cocktail);

		Cocktail storedCocktail = cocktailRepository.findByName("Limonada");

		assertNotNull(storedCocktail);
		assertEquals(cocktail.getName(), storedCocktail.getName());
		assertEquals(cocktail.getDescription(), storedCocktail.getDescription());
	}

}
