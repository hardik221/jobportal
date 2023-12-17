package com.concordia.jobportal.Recruiter.Services;

import com.concordia.jobportal.Recruiter.Models.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class RecruiterRepositoryImpl {
    @Autowired
    private RecruiterRepository recruiterRepository;

    public long getRecordCount() {
        return recruiterRepository.findAll().size();
    }
    public String createRecruiter(Recruiter recruiter) {
        recruiter.setCreatedAt(Instant.now());
        recruiter.setUpdatedAt(Instant.now());
        recruiter.setLastLogin(Instant.now());
        recruiterRepository.save(recruiter);
        return "Recruiter Profile Created";
    }

    public boolean getRecruiterByEmailAndPassword(String email, String password){
        boolean isLogin = false;
        Optional<Recruiter> optional = recruiterRepository.findByEmailAndPassword(email, password);
        if(optional.isPresent()){
            Recruiter recruiter = optional.get();
            recruiter.setLastLogin(Instant.now());
            recruiterRepository.save(recruiter);
            isLogin = true;
        }
        return isLogin;
    }
}
