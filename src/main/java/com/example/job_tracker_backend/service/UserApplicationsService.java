package com.example.job_tracker_backend.service;

import com.example.job_tracker_backend.model.UserApplications;
import com.example.job_tracker_backend.repository.UserApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationsService {

    @Autowired
    private UserApplicationsRepository userApplicationsRepository;

    // Fetch all UserApplications
    public List<UserApplications> getAllUserApplications() {
        return userApplicationsRepository.findAll();
    }

    // Fetch UserApplications by userId
    public List<UserApplications> getUserApplicationsByUserId(Long userId) {
        return userApplicationsRepository.findByUserId(userId);
    }

    // Fetch UserApplications by jobApplicationId
    public List<UserApplications> getUserApplicationsByJobApplicationId(Long jobApplicationId) {
        return userApplicationsRepository.findByJobApplications_Id(jobApplicationId);
    }

    // Fetch a specific UserApplication by ID
    public UserApplications getUserApplicationById(Long id) {
        Optional<UserApplications> userApplication = userApplicationsRepository.findById(id);
        return userApplication.orElse(null);
    }

    // Save a UserApplication
    public UserApplications saveUserApplication(UserApplications userApplications) {
        return userApplicationsRepository.save(userApplications);
    }

    // Delete a UserApplication by ID
    public void deleteUserApplication(Long id) {
        userApplicationsRepository.deleteById(id);
    }
}
