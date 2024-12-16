package com.portalgank.portalgank_api.controller;

import com.portalgank.portalgank_api.dto.UserDetailsResponse;
import com.portalgank.portalgank_api.entity.User;
import com.portalgank.portalgank_api.repository.UserRepository;
import com.portalgank.portalgank_api.service.CustomUserDetailsService;
import com.portalgank.portalgank_api.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;

    public UserController(CustomUserDetailsService userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }
    
    @GetMapping
    public ResponseEntity<?> getUserDetails(Authentication authentication) {
        String email = authentication.getName();
        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!"));

        return ResponseEntity.ok(new UserDetailsResponse(user.getName(), user.getEmail(), user.getRole()));
    }
}
