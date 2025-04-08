package com.example.job_tracker_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_tracker_backend.model.JobSource;
import com.example.job_tracker_backend.service.JobSourceService;

@RestController
@RequestMapping("/api/job-source")
public class JobSourceController {

	@Autowired
	private JobSourceService jobSourceService;


	@GetMapping
    public List<JobSource> getAllSources() {
        return jobSourceService.getAllSources();
    }

    @GetMapping("/{id}")
    public Optional<JobSource> getJobApplicationById(@PathVariable Long id) {
        return Optional.ofNullable(jobSourceService.getSourceById(id));
    }

	@PostMapping
	public JobSource createJobService(@RequestBody JobSource jobSource) {
		return jobSourceService.saveSource(jobSource);
	}

	@DeleteMapping("/{id}")
	public void deleteJobSource(@PathVariable Long id) {
		jobSourceService.deleteSource(id);
	}
}
