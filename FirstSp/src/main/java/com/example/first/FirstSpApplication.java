package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.example")
@EntityScan("com.example.entity")
//@EntityScan(basePackageClasses = {
//	    FirstSpApplication.class,
//	    Jsr310JpaConverters.class
//	})
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class FirstSpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpApplication.class, args);
	}

}