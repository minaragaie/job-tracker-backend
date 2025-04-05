package com.example.job_tracker_backend.model;
import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity 
public class JobSource {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

    @OneToMany(mappedBy = "jobSource") // 'jobSource' is the field in JobApplication class
    private List<JobApplication> jobApplications;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
