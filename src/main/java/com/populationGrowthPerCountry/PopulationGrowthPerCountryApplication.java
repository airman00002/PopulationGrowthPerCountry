package com.populationGrowthPerCountry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PopulationGrowthPerCountryApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(PopulationGrowthPerCountryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("========== Service V.3 is running ==========");

		
	}

}
