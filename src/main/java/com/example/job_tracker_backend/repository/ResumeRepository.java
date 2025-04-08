package com.example.job_tracker_backend.repository;

import com.example.job_tracker_backend.model.Resume;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    // You can add custom queries if needed
    // For example, finding all resumes by user:
    List<Resume> findByUserId(Long userId);
}
