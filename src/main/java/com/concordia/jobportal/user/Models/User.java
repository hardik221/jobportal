package com.concordia.jobportal.user.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String password;
    private boolean isBlocked;
    private Instant lastLogin;
    private Instant createdAt;
    private Instant updatedAt;
}
