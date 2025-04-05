package com.example.job_tracker_backend.repository;

import com.example.job_tracker_backend.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // You can add custom query methods here later if needed
}
