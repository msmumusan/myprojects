package com.example.securitydemo1.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		String pass = String.valueOf(authentication.getCredentials());

		if ("mumu".equals(name) && "12345".equals(pass)) {
			return new UsernamePasswordAuthenticationToken(name, pass);
		} else {
			throw new AuthenticationCredentialsNotFoundException("Error");

		}

	}

	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
