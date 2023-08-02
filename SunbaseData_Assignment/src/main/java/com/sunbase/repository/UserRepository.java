package com.sunbase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbase.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByEmail(String email);
}
