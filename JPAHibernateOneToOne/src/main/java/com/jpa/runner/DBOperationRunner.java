package com.jpa.runner;

import com.jpa.repository.RoleRepository;
import com.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBOperationRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----------All Data saved into Database----------------------");
	}

}