package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.example.*")
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class FirstSpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpApplication.class, args);
	}

}