package com.example.job_tracker_backend.service;

import com.example.job_tracker_backend.model.Resume;
import com.example.job_tracker_backend.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    // Fetch resumes for a specific user by userId
    public List<Resume> getResumesByUserId(Long userId) {
        return resumeRepository.findByUserId(userId);
    }

    // Fetch a resume by its ID
    public Resume getResumeById(Long id) {
        Optional<Resume> resume = resumeRepository.findById(id);
        return resume.orElse(null); // Return null if not found
    }

    // Save or update a resume
    public Resume saveResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    // Delete a resume by ID
    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}
