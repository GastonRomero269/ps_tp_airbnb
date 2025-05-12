package com.unla.ps_tp_airbnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.Property;
import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.repository.PropertyRepository;
import com.unla.ps_tp_airbnb.repository.UserRepository;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PropertyRepository propertyRepository;
	
	public UserServiceImpl(UserRepository userRepository, PropertyRepository propertyRepository) {
		this.userRepository = userRepository;
		this.propertyRepository = propertyRepository;
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
	
    @Override
    public List<Property> getFavorites(Long userId) {
        return propertyRepository.findFavoritesByUserId(userId);
    }
    
    @Transactional
    public void addFavorite(Long userId, Long propertyId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        Property prop = propertyRepository.findById(propertyId).orElseThrow(() -> new EntityNotFoundException("Propiedad no encontrada"));

        if (!user.getFavoriteProperties().contains(prop)) {
            user.addFavorite(prop);  
            userRepository.save(user);      
        }
    }
}
