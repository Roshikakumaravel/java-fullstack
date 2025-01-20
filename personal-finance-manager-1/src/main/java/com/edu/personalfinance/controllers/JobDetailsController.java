package com.edu.personalfinance.controllers;

import com.edu.personalfinance.models.JobDetails;
import com.edu.personalfinance.services.JobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-details")
public class JobDetailsController {

    @Autowired
    private JobDetailsService jobDetailsService;

    // Initial Registration Endpoint
    @PostMapping
    public ResponseEntity<String> saveJobDetails(@RequestBody JobDetails jobDetails) {
        try {
            jobDetailsService.saveJobDetails(jobDetails);
            return ResponseEntity.ok("Job details saved successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());  // Return message if already registered
        }
    }

    // Update Job and Salary Endpoint
    @PutMapping("/{username}/update")
    public ResponseEntity<String> updateJobDetails(@PathVariable String username, @RequestBody JobDetails jobDetails) {
        try {
            jobDetailsService.updateJobDetails(username, jobDetails);
            return ResponseEntity.ok("Job and salary updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());  // Return appropriate message based on conditions
        }
    }
}
