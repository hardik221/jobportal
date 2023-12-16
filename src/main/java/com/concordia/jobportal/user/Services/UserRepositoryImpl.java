package com.concordia.jobportal.user.Services;

import com.concordia.jobportal.user.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
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

    public Optional<User> loginUser(User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }
}
