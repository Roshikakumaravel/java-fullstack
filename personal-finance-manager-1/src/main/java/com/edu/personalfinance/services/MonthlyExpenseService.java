package com.edu.personalfinance.services;

import com.edu.personalfinance.models.JobDetails;
import com.edu.personalfinance.models.MonthlyExpense;
import com.edu.personalfinance.repositories.JobDetailsRepository;
import com.edu.personalfinance.repositories.MonthlyExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MonthlyExpenseService {

    @Autowired
    private MonthlyExpenseRepository monthlyExpenseRepository;

    @Autowired
    private JobDetailsRepository jobDetailsRepository;

    // Add monthly expense for a user
    public MonthlyExpense addMonthlyExpense(String username, MonthlyExpense monthlyExpense) {
        Optional<JobDetails> jobDetails = jobDetailsRepository.findByUsername(username);

        if (!jobDetails.isPresent()) {
            throw new RuntimeException("User not found.");
        }

        monthlyExpense.setJobDetails(jobDetails.get());
        return monthlyExpenseRepository.save(monthlyExpense);
    }

    // Get monthly expenses by username
    public List<MonthlyExpense> getMonthlyExpensesByUsername(String username) {
        return monthlyExpenseRepository.findByJobDetailsUsername(username);
    }
}
