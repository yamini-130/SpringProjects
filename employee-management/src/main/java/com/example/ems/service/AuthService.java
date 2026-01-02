package com.example.ems.service;

import com.example.ems.dto.LoginRequestDTO;
import com.example.ems.dto.LoginResponseDTO;
import com.example.ems.entity.User;
import com.example.ems.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));

        if(!passwordEncoder.matches(dto.getPassword(),user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setUserId(user.getId());
        loginResponseDTO.setEmail(user.getEmail());
        loginResponseDTO.setPassword(user.getPassword());
        loginResponseDTO.setMessage("Login Successful");

        return loginResponseDTO;
    }
}
