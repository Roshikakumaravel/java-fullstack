package com.edu.personalfinance.repositories;

import com.edu.personalfinance.models.JobDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {
    Optional<JobDetails> findByUsername(String username);
}
