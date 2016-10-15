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
