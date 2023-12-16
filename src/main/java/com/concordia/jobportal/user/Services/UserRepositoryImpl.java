package com.concordia.jobportal.user.Services;

import com.concordia.jobportal.user.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl {
    @Autowired
    private UserRepository userRepository;

    public long getRecordCount() {
        return userRepository.findAll().size();
    }
    public String createUser(User user) {
        userRepository.save(user);
        return "User Created Successfully";
    }
}
