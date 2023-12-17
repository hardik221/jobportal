package com.concordia.jobportal.admin.Services;

import com.concordia.jobportal.Recruiter.Models.Recruiter;
import com.concordia.jobportal.Recruiter.Services.RecruiterRepository;
import com.concordia.jobportal.admin.Models.Admin;
import com.concordia.jobportal.user.Models.User;
import com.concordia.jobportal.user.Services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminRepositoryImpl {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecruiterRepository recruiterRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public  List<Recruiter> getAllRecruiters(){
        return recruiterRepository.findAll();
    }
    public String getAdmin(){
        return adminRepository.findAll().get(0).getName();
    }

    public Optional<Admin> getByNameAndPassword(String name, String password) {
        return adminRepository.findByNameAndPassword(name, password);
    }
}
