package com.example.springbootspringsecuritydemo.api;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.springbootspringsecuritydemo.entity.Role;
import com.example.springbootspringsecuritydemo.entity.User;
import com.example.springbootspringsecuritydemo.services.UserService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@GetMapping("/user/${username}")
	public ResponseEntity<User> getUser(@RequestParam("username") String username) {
		return ResponseEntity.ok().body(userService.getUser(username));
	}

	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}

	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}

	@PostMapping("/role/addtouser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
		userService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String authorizationHeader = request.getHeader("AUTHORIZATION");
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {

				String refresh_token = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refresh_token);

				String username = decodedJWT.getSubject();

				User user = userService.getUser(username);

				String access_token = JWT.create().withSubject(user.getUsername())
						.withIssuer(request.getRequestURL().toString())
						.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
						.withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
						.sign(algorithm);

				Map<String, String> tokens = new HashMap<>();
				tokens.put("access_token", access_token);
				tokens.put("refresh_token", refresh_token);

				response.setContentType("APPLICATION_JSON_VALUE");
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);

			} catch (Exception e) {

				log.error("Error Logging in {}", e.getMessage());
				response.setStatus(403);

				Map<String, String> errors = new HashMap<>();
				errors.put("error_message", e.getMessage());
				response.setContentType("APPLICATION_JSON_VALUE");
				new ObjectMapper().writeValue(response.getOutputStream(), errors);

			}

		} else {
			throw new RuntimeException("Refresh_token is messing");
		}

	}
}

@Data
class RoleToUserForm {
	private String username;
	private String roleName;
}
