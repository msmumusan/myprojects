package com.example.springbootspringsecuritydemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootspringsecuritydemo.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
