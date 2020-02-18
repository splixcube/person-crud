package com.ksh.personcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories("com.ksh.repositories")
@EntityScan("com.ksh.entities")
@ComponentScan("com.ksh")
public class PersonCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonCrudApplication.class, args);
	}

}
