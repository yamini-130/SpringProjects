package com.example.ems.controller;

import com.example.ems.dto.CreateUserDTO;
import com.example.ems.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
        return "User created";
    }
}
