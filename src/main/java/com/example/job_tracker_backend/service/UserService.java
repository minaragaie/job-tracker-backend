package com.example.job_tracker_backend.service;

import com.example.job_tracker_backend.model.User;
import com.example.job_tracker_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Fetch a specific user by ID
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null if user not found
    }

    // Fetch a specific user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email); // Assuming you have this method in UserRepository
    }

    // Save a new or existing user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long id, User userDetails) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User existingUserObj = existingUser.get();
            existingUserObj.setFirstName(userDetails.getFirstName());
            existingUserObj.setLastName(userDetails.getLastName());
            existingUserObj.setPhone(userDetails.getPhone());
            existingUserObj.setEmail(userDetails.getEmail());
            return userRepository.save(existingUserObj);
        }
        return null; // User not found, return null
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
