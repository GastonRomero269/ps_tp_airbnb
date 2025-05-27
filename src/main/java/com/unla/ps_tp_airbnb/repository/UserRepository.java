package com.unla.ps_tp_airbnb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.ps_tp_airbnb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);

	Optional<User> findByEmail(String email);
}
