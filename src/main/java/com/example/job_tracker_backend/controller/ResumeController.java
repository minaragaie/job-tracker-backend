package com.example.job_tracker_backend.controller;

import com.example.job_tracker_backend.model.Resume;
import com.example.job_tracker_backend.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    // Get all resumes for a specific user by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Resume>> getResumesByUserId(@PathVariable Long userId) {
        List<Resume> resumes = resumeService.getResumesByUserId(userId);
        if (resumes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no resumes found for the user
        }
        return new ResponseEntity<>(resumes, HttpStatus.OK); // Return 200 with the list of resumes
    }

    // Create or Update a Resume
    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        Resume createdResume = resumeService.saveResume(resume);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED); // Return 201 on successful creation
    }

    // Delete a Resume by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 when deleted successfully
    }

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "Resume API is working!!!";
    }
}
