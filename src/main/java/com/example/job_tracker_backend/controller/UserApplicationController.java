package com.example.job_tracker_backend.controller;

import com.example.job_tracker_backend.model.UserApplications;
import com.example.job_tracker_backend.service.UserApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-applications")
public class UserApplicationController {

    @Autowired
    private UserApplicationsService userApplicationsService;

    // Get all user applications
    @GetMapping
    public List<UserApplications> getAllUserApplications() {
        return userApplicationsService.getAllUserApplications();
    }

    // Get user applications by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserApplications>> getUserApplicationsByUserId(@PathVariable Long userId) {
        List<UserApplications> userApplications = userApplicationsService.getUserApplicationsByUserId(userId);
        if (userApplications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // No user applications found
        }
        return new ResponseEntity<>(userApplications, HttpStatus.OK);
    }

    // Create or associate a user with a job application
    @PostMapping
    public ResponseEntity<UserApplications> createUserApplication(@RequestBody UserApplications userApplications) {
        UserApplications createdUserApplication = userApplicationsService.saveUserApplication(userApplications);
        return new ResponseEntity<>(createdUserApplication, HttpStatus.CREATED);
    }

    // Delete a user application by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserApplication(@PathVariable Long id) {
        userApplicationsService.deleteUserApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Successfully deleted
    }

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "User Application API is working!";
    }
}
