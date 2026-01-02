package com.example.ems.controller;

import com.example.ems.dto.LoginRequestDTO;
import com.example.ems.dto.LoginResponseDTO;
import com.example.ems.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService loginService) {
      this.authService = loginService;
  }

  @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
      return this.authService.login(dto);
  }
}
