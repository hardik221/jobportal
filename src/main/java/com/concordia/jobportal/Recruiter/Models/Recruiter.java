package com.concordia.jobportal.Recruiter.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "recruiter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int company_id;
    private String position;
    private String contactNo;
    private String password;
    private boolean isBlocked;
    private Instant lastLogin;
    private Instant createdAt;
    private Instant updatedAt;
}

