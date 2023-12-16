package com.concordia.jobportal.user.Controller;

import com.concordia.jobportal.user.Models.User;
import com.concordia.jobportal.user.Services.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepositoryImpl userRepositoryImpl;

    @GetMapping("/user")
    public long getUserData() {
        return userRepositoryImpl.getRecordCount();
    }

    @PostMapping("/user/register")
    public String createUser(@RequestBody User user) {
        return userRepositoryImpl.createUser(user);
    }

    @PostMapping("/user/login")
    public String loginUser(@RequestBody User user) {
        Optional<User> optional = userRepositoryImpl.loginUser(user);
        String message = "";
        if(optional.isPresent()) {
            optional.get().setLastLogin(Instant.now());
            message = "Login Success";
        } else {
            message = "Login Fail";
        }
        return message;
    }
}
