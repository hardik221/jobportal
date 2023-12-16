package com.concordia.jobportal.admin.Services;

import com.concordia.jobportal.admin.Models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminRepositoryImpl {
    @Autowired
    AdminRepository adminRepository;

    public String getAdmin(){
        return adminRepository.findAll().get(0).getName();
    }

    public Optional<Admin> getByNameAndPassword(String name, String password) {
        return adminRepository.findByNameAndPassword(name, password);
    }


}
