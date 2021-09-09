package com.example.demo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWAuthentication extends UsernamePasswordAuthenticationFilter  {
	
	private final long JWT_EXPIRED_TIME = 900_000;
	private final String JWT_SECRET_KEY = "1234";
	

	private AuthenticationManager authenticationManager;

	public JWAuthentication(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setFilterProcessesUrl("/jwt");
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		User user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		Authentication auth = authenticationManager.authenticate(token);
		return auth;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		

		String token = JWT.create()
						.withSubject(((User)authResult.getPrincipal()).getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + JWT_EXPIRED_TIME))
						.sign(Algorithm.HMAC256(JWT_SECRET_KEY));
		
		response.addHeader("Authorization", "Bearer " + token);
	}

}
