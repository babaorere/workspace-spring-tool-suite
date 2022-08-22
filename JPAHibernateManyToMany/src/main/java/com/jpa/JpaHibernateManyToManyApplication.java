package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateManyToManyApplication.class, args);
		System.out.println("----------JpaHibernateManyToManyApplication----------------------");
	}

}
