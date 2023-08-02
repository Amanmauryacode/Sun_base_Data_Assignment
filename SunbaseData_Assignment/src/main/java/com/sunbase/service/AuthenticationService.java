package com.sunbase.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbase.config.JwtService;
import com.sunbase.entity.AuthenticationRequest;
import com.sunbase.entity.AuthenticationResponse;
import com.sunbase.entity.RegisterRequest;
import com.sunbase.entity.Role;
import com.sunbase.entity.User;
import com.sunbase.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	public String register(RegisterRequest request) {
		
		User user = new User();
		
		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.USER);
		
		repository.save(user);
		return "Successfull register";
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
		);
		var user = repository.findByEmail(request.getEmail()).orElseThrow();
		System.out.println(user);
		var jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse("Successfull login",jwtToken);
	
	}

}
