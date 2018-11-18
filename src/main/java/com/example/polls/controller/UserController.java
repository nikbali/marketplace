package com.example.polls.controller;

import com.example.polls.dto.UserProfileDTO;
import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.User;

import com.example.polls.repository.UserRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.util.AppConstants;
import com.example.polls.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController { @


    Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserProfileDTO getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        User user = userRepository.findByLogin(currentUser.getUsername()).get();
        UserProfileDTO userProfileDTO = ModelMapper.fromUserToUserProfileDTO(user);
        return userProfileDTO;
    }


    @GetMapping("/user/operations")
    @PreAuthorize("hasRole('USER')")
    public UserProfileDTO loadOperationsByUser(@CurrentUser UserPrincipal currentUser) {
        User user = userRepository.findByLogin(currentUser.getUsername()).get();
        user.getOperations();
        UserProfileDTO userProfileDTO = ModelMapper.fromUserToUserProfileDTO(user);
        return userProfileDTO;
    }


}
