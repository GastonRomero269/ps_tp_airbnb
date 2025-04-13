package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.unla.ps_tp_airbnb.model.User;

public interface UserService {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(Long id);
    Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);
    Optional<User> findByEmail(String email);
}
