package com.example.spring311.controller;

import com.example.spring311.service.RoleService;
import com.example.spring311.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUser(@AuthenticationPrincipal UserDetails user,
        Model model) {
        userService.getUserByLogin(user.getUsername()).ifPresent(
            model::addAttribute);
        model.addAttribute("roles", roleService.getAllRoles());
        return "user";
    }


}
