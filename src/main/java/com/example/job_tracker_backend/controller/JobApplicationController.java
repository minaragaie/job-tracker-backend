package com.example.job_tracker_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_tracker_backend.model.JobApplication;
import com.example.job_tracker_backend.service.JobApplicationService;
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
    public Optional<JobApplication> getJobApplicationById(@PathVariable Long id) {
        return Optional.ofNullable(jobApplicationService.getApplicationById(id));
    }

    // Create or Update a Job Application
    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.saveApplication(jobApplication);
    }

    // Delete a Job Application by ID
    @DeleteMapping("/{id}")
    public void deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteApplication(id);
    }

	@GetMapping("/test")
    public String test() {
        return "API is working!!!";
    }
}
