package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class FirstSpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpApplication.class, args);
	}

}