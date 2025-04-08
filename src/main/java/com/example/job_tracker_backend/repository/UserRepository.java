package com.example.job_tracker_backend.repository;

import com.example.job_tracker_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
    // For example, finding a user by email:
    User findByEmail(String email);
}