package com.qa.VetSurgeryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VetSurgeryApp {

	public static void main(String[] args) {
		
		SpringApplication.run(VetSurgeryApp.class, args);
	}
}
