package com.concordia.jobportal.user.Services;

import com.concordia.jobportal.user.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    List<User> findAll();

    @Query("{'email' : ?0, 'password' : ?1}")
    Optional<User> findByEmailAndPassword(String email, String password);

}
