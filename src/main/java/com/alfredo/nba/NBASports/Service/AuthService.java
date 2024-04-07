package com.alfredo.nba.NBASports.Service;

import com.alfredo.nba.NBASports.Models.LoginRequest;
import com.alfredo.nba.NBASports.Models.LoginResponse;
import com.alfredo.nba.NBASports.Models.User;
import com.alfredo.nba.NBASports.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public LoginResponse login(LoginRequest request) {
        User user = null;

        try {
            user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        } catch (NoSuchElementException e) {
            return LoginResponse.builder()
                    .message("User not found.")
                    .build();
        }

        if (!userService.isPasswordMatch(user, request.getPassword())) {
            return LoginResponse.builder()
                    .message("Incorrect password.")
                    .build();
        }

        return LoginResponse.builder()
                .name(user.getName())
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}

