package com.example.job_tracker_backend.controller;

import com.example.job_tracker_backend.model.JobApplication;
import com.example.job_tracker_backend.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    // Get all Job Applications
    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllApplications();
    }

    // Get a Job Application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        JobApplication jobApplication = jobApplicationService.getApplicationById(id);
        if (jobApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
        return new ResponseEntity<>(jobApplication, HttpStatus.OK); // Return 200 with job application if found
    }

    // Create or Update a Job Application
    @PostMapping
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication createdJobApplication = jobApplicationService.saveApplication(jobApplication);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED); // Return 201 on successful creation
    }

    // Delete a Job Application by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 when deleted successfully
    }

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "API is working!!!";
    }
}
