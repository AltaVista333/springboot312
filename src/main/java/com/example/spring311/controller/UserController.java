package com.example.spring311.controller;

import com.example.spring311.model.User;
import com.example.spring311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersTable(Model model) {
        model.addAttribute("allUsersTable", userService.getAllUsers());
        return "users-view";
    }

    @GetMapping("/new")
    public String getUserCreateForm(@ModelAttribute User user) {
        return "user-modify-form";
    }

    @GetMapping("/update/{id}")
    public String getUserUpdateForm(@PathVariable Long id, Model model) {
        return userService.getUserById(id).map(model::addAttribute).isPresent()
            ? "user-modify-form" : "redirect:/";
    }

    @PostMapping("/new/add")
    public String addNewOrUpdateUser(
        @ModelAttribute("user") @Validated User user, BindingResult result) {

        if (result.hasErrors()) {
            return "user-modify-form";
        }
        userService.updateOrSaveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
