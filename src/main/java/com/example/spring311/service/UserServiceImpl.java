package com.example.spring311.service;

import com.example.spring311.model.User;
import com.example.spring311.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        getUserById(user.getId()).ifPresent(x -> repository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        return repository.findByLogin(username)
            .map(x -> new org.springframework.security.core.userdetails.User(x.getLogin(),
                x.getPassword(),
                x.getRoles()))
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
