package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.models.User;
import com.example.repository.UserRepository;


@EntityScan("com.example.models")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class UserModuleApplication  implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(UserModuleApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Jack", "jack.123","jack@gmail.com"));
		repository.save(new User("Chloe", "chloe.345","chloe123@hotmail.com"));
		repository.save(new User("Kim", "samsung43","kimy5@gmail.com"));
		repository.save(new User("David", "victoria89","davidB@live.com"));
		repository.save(new User("Michelle", "john500","john.500@live.com"));
	}
}
