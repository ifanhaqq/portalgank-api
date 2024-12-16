package com.portalgank.portalgank_api.util;

import com.portalgank.portalgank_api.entity.User;
import com.portalgank.portalgank_api.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    private final UserRepository userRepository;

    public SecurityUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("No authenticated user found");
        }

        String email = authentication.getName();
        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!"));

        return user.getId();
    }
}
