package com.edu.personalfinance.services;

import com.edu.personalfinance.models.JobDetails;
import com.edu.personalfinance.repositories.JobDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobDetailsService {

    @Autowired
    private JobDetailsRepository jobDetailsRepository;

    // Save initial job details
    public JobDetails saveJobDetails(JobDetails jobDetails) {
        // Check if the username already exists
        Optional<JobDetails> existing = jobDetailsRepository.findByUsername(jobDetails.getUsername());

        if (existing.isPresent()) {
            return existing.get();  // Return the existing details if already saved
        }

        // If new, save job details
        return jobDetailsRepository.save(jobDetails);
    }

    // Update Job and Salary multiple times without finalization
    public JobDetails updateJobDetails(String username, JobDetails jobDetails) {
        Optional<JobDetails> existing = jobDetailsRepository.findByUsername(username);

        if (!existing.isPresent()) {
            throw new RuntimeException("User not found.");
        }

        JobDetails existingDetails = existing.get();

        // Allow user to update job and salary
        existingDetails.setJob(jobDetails.getJob());
        existingDetails.setSalary(jobDetails.getSalary());

        return jobDetailsRepository.save(existingDetails);
    }
}
