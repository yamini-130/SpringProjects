package com.example.ems.service;

import com.example.ems.dto.CreateUserDTO;
import com.example.ems.entity.User;
import com.example.ems.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void createUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        userRepository.save(user);
    }
}
