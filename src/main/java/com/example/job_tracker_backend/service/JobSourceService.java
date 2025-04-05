package com.example.job_tracker_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_tracker_backend.model.JobSource;
import com.example.job_tracker_backend.repository.JobSourceRepository;

@Service
public class JobSourceService {
	@Autowired
    private JobSourceRepository repository;

    public List<JobSource> getAllSources() {
        return repository.findAll();
    }

    public JobSource saveSource(JobSource job) {
        return repository.save(job);
    }

    public void deleteSource(Long id) {
        repository.deleteById(id);
    }

    public JobSource getSourceById(Long id) {
        return repository.findById(id).orElse(null);
    }
	
}
