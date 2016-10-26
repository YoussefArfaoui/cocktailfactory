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

import com.cocktail.model.User;
import com.cocktail.repository.UserRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CocktailApplication extends WebMvcConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(CocktailApplication.class);
	
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
	    logger.info("HttpMessageConverter added");

	    // string
	    converter = new FormHttpMessageConverter();
	    converters.add(converter);
	    logger.info("FormHttpMessageConverter added");

	    // json
	    converter = new MappingJackson2HttpMessageConverter();
	    converters.add(converter);
	    logger.info("MappingJackson2HttpMessageConverter added");

	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
