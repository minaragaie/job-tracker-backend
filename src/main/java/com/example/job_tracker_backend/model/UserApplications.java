package com.example.job_tracker_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import java.util.List;

@Entity
public class UserApplications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the ID
    private Long id; // Primary key

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key for user
    private User user;

    @OneToMany(mappedBy = "userApplications", cascade = CascadeType.ALL) // Cascade and map by the field in the JobApplication class
    private List<JobApplication> jobApplications;

    // Constructors
    public UserApplications() {}

    public UserApplications(User user, List<JobApplication> jobApplications) {
        this.user = user;
        this.jobApplications = jobApplications;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
