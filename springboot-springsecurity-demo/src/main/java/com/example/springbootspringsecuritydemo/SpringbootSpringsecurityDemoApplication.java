package com.example.springbootspringsecuritydemo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.springbootspringsecuritydemo.entity.Role;
import com.example.springbootspringsecuritydemo.entity.User;
import com.example.springbootspringsecuritydemo.services.UserService;

@SpringBootApplication
public class SpringbootSpringsecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringsecurityDemoApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "MuMuSan", "mumu", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "NayBhoneMyint", "naybhone", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "ThazinNway", "thazin", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "EaintChuuPyae", "eaintchuu", "123456", new ArrayList<>()));

			userService.addRoleToUser("mumu", "ROLE_MANAGER");
			userService.addRoleToUser("mumu", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("naybhone", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("thazin", "ROLE_USER");
			userService.addRoleToUser("eaintchuu", "ROLE_USER");
		};
	}

	

}
