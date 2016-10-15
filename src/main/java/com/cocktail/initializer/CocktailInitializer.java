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
package com.cocktail.initializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.cocktail.initializer.staticdata.CocktailIngredientData;
import com.cocktail.initializer.staticdata.StepData;
import com.cocktail.model.Cocktail;
import com.cocktail.model.CocktailIngredient;
import com.cocktail.model.Ingredient;
import com.cocktail.model.IngredientType;
import com.cocktail.model.Step;
import com.cocktail.model.Unit;
import com.cocktail.repository.CocktailIngredientRepository;
import com.cocktail.repository.CocktailRepository;
import com.cocktail.repository.IngredientReporitory;
import com.cocktail.repository.StepRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Component initializing a hand full of Cocktail DB for testing purpose.
 * 
 * @author arfaouiy
 *
 */

/** The Constant log. */
@Slf4j
@Component
public class CocktailInitializer {

	/**
	 * Instantiates a new Cocktail initializer.
	 *
	 * @param ingredientRepository
	 *            the ingredient repository
	 * @param stepRepository
	 *            the step repository
	 * @param cocktailIngredientRepository
	 *            the cocktail ingredient repository
	 * @param cocktailRepository
	 *            the cocktail repository
	 * @throws Exception
	 *             the exception
	 */
	@Autowired
	public CocktailInitializer(IngredientReporitory ingredientRepository, StepRepository stepRepository,
			CocktailIngredientRepository cocktailIngredientRepository, CocktailRepository cocktailRepository)
			throws Exception {

		if (ingredientRepository.count() != 0) {
			return;
		}
		// ingredients
		List<Ingredient> ingredients = ItemReader.readItems("staticData/ingredients.csv",
				IngredientFieldSetMapper.INSTANCE);
		log.info("Importing {} ingredients into DB…", ingredients.size());
		List<Ingredient> persitedIngredients = (List<Ingredient>) ingredientRepository.save(ingredients);
		log.info("Successfully imported {} ingredients.", ingredientRepository.count());
		// cocktails
		List<Cocktail> cocktails = ItemReader.readItems("staticData/cocktails.csv", CocktailFieldSetMapper.INSTANCE);
		log.info("Importing {} cocktails into DB…", cocktails.size());
		// Steps
		List<StepData> stepData = ItemReader.readItems("staticData/steps.csv", StepFieldSetMapper.INSTANCE);
		log.info("Importing {} steps into DB…", stepData.size());
		// Cocktail ingredients
		List<CocktailIngredientData> cocktailIngredients = ItemReader.readItems("staticData/cocktailIngredients.csv",
				CocktailIngredientFieldSetMapper.INSTANCE);
		log.info("Importing {} steps into DB…", stepData.size());
		// Set the steps for the cocktail
		setCocktailSteps(cocktails, stepData);
		setCocktailIngredients(cocktails, cocktailIngredients, persitedIngredients);
		// save the cocktails
		cocktailRepository.save(cocktails);
		log.info("Successfully imported {} cocktails.", cocktailRepository.count());

	}

	/**
	 * Sets the cocktail ingredients.
	 *
	 * @param cocktails
	 *            the cocktails
	 * @param cocktailIngredients
	 *            the cocktail ingredients
	 * @param persitedIngredients
	 *            the persited ingredients
	 */
	private void setCocktailIngredients(List<Cocktail> cocktails, List<CocktailIngredientData> cocktailIngredients,
			List<Ingredient> persitedIngredients) {

		// link the ingredient to the CocktailIngredient
		for (CocktailIngredientData docktailIngredientData : cocktailIngredients) {
			for (Ingredient ingredient : persitedIngredients) {
				if (docktailIngredientData.getIngredient().equalsIgnoreCase(ingredient.getName())) {
					docktailIngredientData.getCocktailIngredient().setIngredient(ingredient);
				}
			}

		}
		// link the cocktail ingredient to the cocktails
		for (Cocktail cocktail : cocktails) {
			List<CocktailIngredient> cocktailIngredientList = new ArrayList<>();
			for (CocktailIngredientData docktailIngredientData : cocktailIngredients) {
				if (docktailIngredientData.getCocktail().equalsIgnoreCase(cocktail.getName())) {
					cocktailIngredientList.add(docktailIngredientData.getCocktailIngredient());
				}

			}

			cocktail.setCocktailIngredients(cocktailIngredientList);
		}

	}

	/**
	 * Sets the cocktail steps.
	 *
	 * @param cocktails
	 *            the cocktails
	 * @param stepData
	 *            the step data
	 */
	private void setCocktailSteps(List<Cocktail> cocktails, List<StepData> stepData) {
		Map<String, List<StepData>> groupedSteps = stepData.stream()
				.collect(Collectors.groupingBy(p -> p.getCocktail().toUpperCase()));

		for (Cocktail cocktail : cocktails) {
			List<Step> steps = new ArrayList<>();
			groupedSteps.get(cocktail.getName().toUpperCase()).forEach(s -> steps.add(s.getStep()));
			cocktail.setSteps(steps);
		}

	}
	
	/**
	 * The Enum IngredientFieldSetMapper.
	 */
	private static enum IngredientFieldSetMapper implements FieldSetMapper<Ingredient> {

		/** The instance. */
		INSTANCE;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.batch.item.file.mapping.FieldSetMapper#
		 * mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
		 */
		@Override
		public Ingredient mapFieldSet(FieldSet fields) throws BindException {

			return new Ingredient(null, null, fields.readString("name"), fields.readString("description"), null,
					IngredientType.valueOf(fields.readString("type")));
		}
	}

	/**
	 * The Enum StepFieldSetMapper.
	 */
	private static enum StepFieldSetMapper implements FieldSetMapper<StepData> {

		/** The instance. */
		INSTANCE;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.batch.item.file.mapping.FieldSetMapper#
		 * mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
		 */
		@Override
		public StepData mapFieldSet(FieldSet fields) throws BindException {

			return new StepData(new Step(null, null, fields.readString("name"), fields.readString("description"),
					fields.readInt("orderNumber")), fields.readString("cocktailId"));

		}
	}

	/**
	 * The Enum CocktailFieldSetMapper.
	 */
	private static enum CocktailFieldSetMapper implements FieldSetMapper<Cocktail> {

		/** The instance. */
		INSTANCE;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.batch.item.file.mapping.FieldSetMapper#
		 * mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
		 */
		@Override
		public Cocktail mapFieldSet(FieldSet fields) throws BindException {

			Cocktail cocktail = new Cocktail();
			cocktail.setName(fields.readString("name"));
			cocktail.setDescription(fields.readString("description"));
			cocktail.setRate(fields.readInt("rate"));
			cocktail.setDuration(Duration.ofMinutes(fields.readInt("duration")));
			return cocktail;

		}
	}

	/**
	 * The Enum CocktailIngredientFieldSetMapper.
	 */
	private static enum CocktailIngredientFieldSetMapper implements FieldSetMapper<CocktailIngredientData> {

		/** The instance. */
		INSTANCE;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.batch.item.file.mapping.FieldSetMapper#
		 * mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
		 */
		@Override
		public CocktailIngredientData mapFieldSet(FieldSet fields) throws BindException {

			return new CocktailIngredientData(fields.readString("cocktailId"), fields.readString("ingredientId"),
					new CocktailIngredient(null, null, fields.readBigDecimal("quantity"),
							Unit.valueOf(fields.readString("unit")), fields.readBoolean("optional"), null));

		}
	}
}
