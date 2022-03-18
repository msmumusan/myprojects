package com.example.springbootspringsecuritydemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootspringsecuritydemo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
