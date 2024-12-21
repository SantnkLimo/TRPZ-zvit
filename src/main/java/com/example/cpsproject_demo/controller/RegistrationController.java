package com.example.cpsproject_demo.controller;

import com.example.cpsproject_demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService userService;
    @Autowired
    public RegistrationController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword) {
        try {
            userService.registerUser(name, email, password, confirmPassword);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            return "register";
        }
    }

    @GetMapping("/success")
    public String registrationSuccess() {
        return "registration-success";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}

