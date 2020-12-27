package com.bawnya.ravid.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.bawnya.ravid.learning.persistance.repos" })
public class AzureExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureExampleApplication.class, args);
	}

}
