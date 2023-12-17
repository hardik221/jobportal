package com.concordia.jobportal.Recruiter.Controller;

import com.concordia.jobportal.Recruiter.Models.Recruiter;
import com.concordia.jobportal.Recruiter.Services.RecruiterRepositoryImpl;
import com.concordia.jobportal.common.SequenceGenerator;
import com.concordia.jobportal.common.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecruiterController {
    @Autowired
    RecruiterRepositoryImpl recruiterRepositoryImpl;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @GetMapping("/hr/")
    public long getUserData() {
        return recruiterRepositoryImpl.getRecordCount();
    }

    @PostMapping("/hr/register")
    public String createRecruiter(@RequestBody Recruiter recruiter) {
        recruiter.setId(sequenceGenerator.generateSequence(Type.RECRUITER.toString()));
        return recruiterRepositoryImpl.createRecruiter(recruiter);
    }

    @PostMapping("/hr/login")
    public String onLogin(@RequestBody Recruiter recruiter){
        boolean isLogin = recruiterRepositoryImpl.getRecruiterByEmailAndPassword(recruiter.getEmail(), recruiter.getPassword());
        return (isLogin ? "Login Successfull" : "Login failed");
    }

}
