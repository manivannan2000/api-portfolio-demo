package com.storepoints.apiportfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.storepoints.apiportfolio.domain.Advisor;
import com.storepoints.apiportfolio.domain.AdvisorRepository;

@SpringBootApplication
public class ApiPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPortfolioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AdvisorRepository repository) {
		
		return (args)->{
			// save a couple of advisors
			repository.save(new Advisor("Advisor 1", "advisor1"));
			repository.save(new Advisor("Advisor 2", "advisor2"));
		};
		
	}
	
}
