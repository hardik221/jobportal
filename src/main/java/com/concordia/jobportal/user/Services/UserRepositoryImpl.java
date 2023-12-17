package com.concordia.jobportal.user.Services;

import com.concordia.jobportal.user.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.Optional;

@Service
public class UserRepositoryImpl {
    @Autowired
    private UserRepository userRepository;

    public long getRecordCount() {
        return userRepository.findAll().size();
    }
    public String createUser(User user) {
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        user.setLastLogin(Instant.now());
        userRepository.save(user);
        return "User Created Successfully";
    }

    public String loginUser(User user) {
        Optional<User> optional = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        String message = "";
        if(optional.isPresent()) {
            User loggedInUser = optional.get();
            loggedInUser.setLastLogin(Instant.now());
            userRepository.save(loggedInUser); // Assuming you want to save the updated user.
            message = "Login Success";
        } else {
            message = "Login Fail";
        }

        return message;
    }
}
