package com.concordia.jobportal.user.Services;

import com.concordia.jobportal.user.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {
    List<User> findAll();

    @Query("{'name' : ?0, 'password' : ?1}")
    User findByNameAndPassword(String name, String password);

}
