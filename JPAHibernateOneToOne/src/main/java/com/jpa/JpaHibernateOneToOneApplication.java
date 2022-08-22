package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateOneToOneApplication.class, args);
		System.out.println("----------JpaHibernateOneToOneApplication----------------------");
	}

}
