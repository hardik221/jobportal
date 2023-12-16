package com.concordia.jobportal.admin.Services;

import com.concordia.jobportal.admin.Models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends MongoRepository<Admin, Integer> {
    List<Admin> findAll();

    @Query("{'name' : ?0, 'password' : ?1}")
    Optional<Admin> findByNameAndPassword(String name, String password);

}
