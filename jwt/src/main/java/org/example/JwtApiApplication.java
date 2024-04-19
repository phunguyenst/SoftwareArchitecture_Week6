package org.example;

import org.example.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JwtApiApplication {
	@Autowired
	private UserServiceImpl userService;
	public static void main(String[] args) {
		SpringApplication.run(JwtApiApplication.class, args);
	}

}
