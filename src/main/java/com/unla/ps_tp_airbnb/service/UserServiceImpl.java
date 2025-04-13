package com.unla.ps_tp_airbnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.repository.UserRepository;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> findByEmailAndPasswordHash(String email, String passwordHash) {
		return userRepository.findByEmailAndPasswordHash(email, passwordHash);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
