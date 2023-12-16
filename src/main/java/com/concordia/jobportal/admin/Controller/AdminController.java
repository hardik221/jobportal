package com.concordia.jobportal.admin.Controller;

import com.concordia.jobportal.admin.Models.Admin;
import com.concordia.jobportal.admin.Services.AdminRepository;
import com.concordia.jobportal.admin.Services.AdminRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    AdminRepositoryImpl adminRepositoryImpl;

    @GetMapping("/")
    public String getAdminData() {
        return adminRepositoryImpl.getAdmin();
    }

    @PostMapping("/")
    public String onLogin(@RequestBody Admin admin) {
        Optional<Admin> optionalAdmin = adminRepositoryImpl.getByNameAndPassword(admin.getName(), admin.getPassword());
        String message = "";
        if(optionalAdmin.isPresent()) {
            message = "Login Success";
        } else {
            message = "Login Failed";
        }

        return message;
    }
}
