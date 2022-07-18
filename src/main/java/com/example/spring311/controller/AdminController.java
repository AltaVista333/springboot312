package com.example.spring311.controller;

import com.example.spring311.model.User;
import com.example.spring311.service.RoleService;
import com.example.spring311.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public static final String REDIRECT_TO_ADMIN_INDEX = "redirect:/admin";

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAdminIndexPage(@AuthenticationPrincipal UserDetails user,
        Model model) {

        userService.getUserByLogin(user.getUsername()).ifPresent(
            model::addAttribute);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {

        userService.addUser(user);
        return REDIRECT_TO_ADMIN_INDEX;
    }

    @PutMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return REDIRECT_TO_ADMIN_INDEX;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)  {
        userService.deleteUserById(id);
        return REDIRECT_TO_ADMIN_INDEX;
    }




}
