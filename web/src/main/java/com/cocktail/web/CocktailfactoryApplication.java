package com.cocktail.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cocktail.*")
public class CocktailfactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocktailfactoryApplication.class, args);
	}
}
