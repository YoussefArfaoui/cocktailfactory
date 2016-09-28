package com.cocktail;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cocktail.model.User;
import com.cocktail.repository.UserRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CocktailApplication {

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
}
