package com.example.spring311.service;

import com.example.spring311.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

public class AuthoritiesUpdater {
    private final UserService userService;

    public AuthoritiesUpdater(UserService userService) {
        this.userService = userService;
    }


}
