package com.concordia.jobportal.Recruiter.Services;

import com.concordia.jobportal.Recruiter.Models.Recruiter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface RecruiterRepository extends MongoRepository<Recruiter, Long> {
//    List<Recruiter> findAll();

    @Query("{'email' : ?0, 'password' : ?1}")
    Optional<Recruiter> findByEmailAndPassword(String email, String password);

//    void updateRecruiterField(String email, String password);
}
