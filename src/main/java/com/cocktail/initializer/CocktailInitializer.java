package com.cocktail.initializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.cocktail.model.Ingredient;
import com.cocktail.model.IngredientType;
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

		List<Ingredient> ingredients = readIngredient();
		log.info("Importing {} stores into DB…", ingredients.size());
		ingredientRepository.save(ingredients);
		log.info("Successfully imported {} stores.", ingredientRepository.count());
	}

	/**
	 * Reads a file {@code ingrediens.csv} from the class path and parses it
	 * into {@link Ingredient} instances about to persisted.
	 *
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	public static List<Ingredient> readIngredient() throws Exception {

		ClassPathResource resource = new ClassPathResource("ingredients.csv");
		Scanner scanner = new Scanner(resource.getInputStream());
		String line = scanner.nextLine();
		scanner.close();

		FlatFileItemReader<Ingredient> itemReader = new FlatFileItemReader<Ingredient>();
		itemReader.setResource(resource);

		// DelimitedLineTokenizer defaults to comma as its delimiter
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames(line.split(","));
		tokenizer.setStrict(false);

		DefaultLineMapper<Ingredient> lineMapper = new DefaultLineMapper<Ingredient>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(IngredientFieldSetMapper.INSTANCE);
		itemReader.setLineMapper(lineMapper);
		itemReader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
		itemReader.setLinesToSkip(1);
		itemReader.open(new ExecutionContext());

		List<Ingredient> ingredients = new ArrayList<>();
		Ingredient ingredient = null;

		do {

			ingredient = itemReader.read();

			if (ingredient != null) {
				ingredients.add(ingredient);
			}

		} while (ingredient != null);

		return ingredients;
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
}