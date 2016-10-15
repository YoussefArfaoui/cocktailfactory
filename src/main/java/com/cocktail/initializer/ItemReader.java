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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

/**
 * The Class ItemReader.
 *
 * @author arfaouiy
 * @param <I>
 *            the generic type
 */

public class ItemReader<I> {

	/**
	 * Read items.
	 *
	 * @param <I>
	 *            the generic type
	 * @param path
	 *            the path
	 * @param itemMapper
	 *            the item mapper
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	public static <I> List<I> readItems(String path, FieldSetMapper<I> itemMapper) throws Exception {

		ClassPathResource resource = new ClassPathResource(path);
		Scanner scanner = new Scanner(resource.getInputStream());
		String line = scanner.nextLine();
		scanner.close();

		FlatFileItemReader<I> itemReader = new FlatFileItemReader<I>();
		itemReader.setResource(resource);

		// DelimitedLineTokenizer defaults to | as its delimiter
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer("|");
		tokenizer.setNames(line.split("\\|"));
		tokenizer.setStrict(false);

		DefaultLineMapper<I> lineMapper = new DefaultLineMapper<I>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(itemMapper);
		itemReader.setLineMapper(lineMapper);
		itemReader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
		itemReader.setLinesToSkip(1);
		itemReader.open(new ExecutionContext());

		List<I> items = new ArrayList<>();
		I item = null;

		do {

			item = itemReader.read();

			if (item != null) {
				items.add(item);
			}

		} while (item != null);

		return items;
	}

}
