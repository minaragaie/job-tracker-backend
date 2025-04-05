package com.example.job_tracker_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_tracker_backend.model.JobApplication;
import com.example.job_tracker_backend.repository.JobApplicationRepository;
@Service
public class JobApplicationService {
	@Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public JobApplication saveApplication(JobApplication job) {
        return repository.save(job);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }

    public JobApplication getApplicationById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
