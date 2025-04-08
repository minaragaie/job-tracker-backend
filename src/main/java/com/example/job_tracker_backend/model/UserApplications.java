package com.example.job_tracker_backend.model;

import java.util.List;

public class UserApplications {
    private User user;  // Reference to the full User object
    private List<JobApplication> jobApplications;

    // Constructors
    public UserApplications() {}

    public UserApplications(User user, List<JobApplication> jobApplications) {
        this.user = user;
        this.jobApplications = jobApplications;
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
