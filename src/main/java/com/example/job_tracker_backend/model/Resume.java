package com.example.job_tracker_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  // Title of the resume (e.g., "Software Engineer Resume")
    private String filePath;  // Path to the file or a URL to the resume (can be used if stored remotely)
    private LocalDate dateCreated;  // Date the resume was created
    private String content;  // Optional: Resume content if stored as text

    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key to the User entity
    private User user;

    // Constructors
    public Resume() {}

    public Resume(String title, String filePath, LocalDate dateCreated, String content, User user) {
        this.title = title;
        this.filePath = filePath;
        this.dateCreated = dateCreated;
        this.content = content;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
