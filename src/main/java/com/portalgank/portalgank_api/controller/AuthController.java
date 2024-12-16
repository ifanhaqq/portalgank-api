package com.portalgank.portalgank_api.controller;

import com.portalgank.portalgank_api.dto.AuthRequest;
import com.portalgank.portalgank_api.dto.AuthResponse;
import com.portalgank.portalgank_api.dto.RegistrationRequest;
import com.portalgank.portalgank_api.entity.User;
import com.portalgank.portalgank_api.service.CustomUserDetailsService;
import com.portalgank.portalgank_api.service.RegistrationService;
import com.portalgank.portalgank_api.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final RegistrationService registrationService;

    public AuthController(RegistrationService registrationService, JwtUtil jwtUtil, AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.registrationService = registrationService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            String token = jwtUtil.generateToken(authentication.getName());
            return new AuthResponse(token);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials", e);
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        registrationService.registerUser(request);
        return "User registered successfully";
    }
}
