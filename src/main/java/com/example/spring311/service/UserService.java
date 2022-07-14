package com.example.spring311.service;

import com.example.spring311.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    Optional<User> getUserById(Long id);

    void deleteUserById(Long id);

    void updateUser(User user);

    void updateOrSaveUser(User user);
}
