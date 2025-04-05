package com.example.job_tracker_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String role;
    private String status; // e.g., Applied, Interviewing, Offered, Rejected
    private LocalDate dateApplied;
    private String applicationDetails;


    @ManyToOne // Many job applications can belong to one job source
    @JoinColumn(name = "job_source_id") // Foreign key column

    private JobSource jobSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(String applicationDetails) {
        this.applicationDetails = applicationDetails;
    }

    public JobSource getJobSource() {
        return jobSource;
    }

    public void setJobSource(JobSource jobSource) {
        this.jobSource = jobSource;
    }
}
