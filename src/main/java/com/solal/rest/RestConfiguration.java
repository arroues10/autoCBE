package com.solal.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class was created to allow Spring to manage objects that I did not
 * create myself in the project
 * 
 * @author Solal Arroues
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class RestConfiguration {

	@Bean(name = "tokens")
	public Map<String, ClientSession> tokensMap() {
		return new HashMap<>();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8100", "http://localhost:4200",
						"https://autocfe.herokuapp.com").allowedMethods("*");
			}

		};
	}
}
