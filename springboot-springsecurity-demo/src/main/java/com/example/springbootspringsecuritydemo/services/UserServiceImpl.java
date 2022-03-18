package com.example.springbootspringsecuritydemo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootspringsecuritydemo.entity.Role;
import com.example.springbootspringsecuritydemo.entity.User;
import com.example.springbootspringsecuritydemo.repo.RoleRepo;
import com.example.springbootspringsecuritydemo.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepo userRepo;

	private final RoleRepo roleRepo;
	
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			log.error("User Not found in Database...." + username);
			throw new UsernameNotFoundException("User Not Found in Database");
		} else {
			log.info("User Found in Database" + username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

	@Override
	public User saveUser(User user) {
		log.info("Save User {} to Database" , user.getUsername());
		//save endcoding password to DB
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Save Role{} to Database" , role);
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);

	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username);
	}

}
