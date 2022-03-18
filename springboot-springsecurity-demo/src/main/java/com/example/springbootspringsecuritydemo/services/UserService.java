package com.example.springbootspringsecuritydemo.services;

import java.util.List;

import com.example.springbootspringsecuritydemo.entity.Role;
import com.example.springbootspringsecuritydemo.entity.User;

public interface UserService {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);
	
	User getUser(String username);

	List<User> getUsers();

}
