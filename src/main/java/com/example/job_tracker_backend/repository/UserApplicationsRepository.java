package com.example.job_tracker_backend.repository;

import com.example.job_tracker_backend.model.UserApplications;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationsRepository extends JpaRepository<UserApplications, Long> {
    // You can add custom queries if needed, such as finding by user or job application
    List<UserApplications> findByUserId(Long userId);
    List<UserApplications> findByJobApplications_Id(Long jobApplicationId);
}
