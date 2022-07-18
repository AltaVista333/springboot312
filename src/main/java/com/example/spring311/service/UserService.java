package com.example.spring311.service;

import com.example.spring311.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void addUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByLogin(String login);

    void deleteUserById(Long id);

    void updateUser(User user);


}
