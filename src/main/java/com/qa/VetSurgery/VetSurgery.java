package com.qa.VetSurgery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VetSurgery {

	public static void main(String[] args) {
		
		SpringApplication.run(VetSurgery.class, args);
	}
}
