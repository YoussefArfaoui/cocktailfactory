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
package com.cocktail;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cocktail.initializer.CocktailInitializer;
import com.cocktail.model.User;
import com.cocktail.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CocktailApplication extends WebMvcConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(CocktailApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final UserRepository userRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				userRepository.save(new User("adelgo", "adelgo"));
				userRepository.save(new User("youssef", "youssef"));
			}

		};
	}

	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

	    // http
	    HttpMessageConverter converter = new StringHttpMessageConverter();
	    converters.add(converter);
	    log.info("HttpMessageConverter added");

	    // string
	    converter = new FormHttpMessageConverter();
	    converters.add(converter);
	    log.info("FormHttpMessageConverter added");

	    // json
	    converter = new MappingJackson2HttpMessageConverter();
	    converters.add(converter);
	    log.info("MappingJackson2HttpMessageConverter added");

	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
