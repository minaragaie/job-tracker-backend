package com.example.job_tracker_backend.repository;
import com.example.job_tracker_backend.model.JobSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSourceRepository extends JpaRepository<JobSource, Long> {
	
}
