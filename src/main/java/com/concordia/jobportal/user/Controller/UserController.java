package com.concordia.jobportal.user.Controller;

import com.concordia.jobportal.common.SequenceGenerator;
import com.concordia.jobportal.common.Type;
import com.concordia.jobportal.user.Models.User;
import com.concordia.jobportal.user.Services.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @GetMapping("/user")
    public long getUserData() {
        return userRepositoryImpl.getRecordCount();
    }

    @PostMapping("/user/register")
    public String createUser(@RequestBody User user) {
        user.setId(sequenceGenerator.generateSequence(Type.USER.toString()));
        return userRepositoryImpl.createUser(user);
    }

    @PostMapping("/user/login")
    public String loginUser(@RequestBody User user) {
        return userRepositoryImpl.loginUser(user);
    }
}
