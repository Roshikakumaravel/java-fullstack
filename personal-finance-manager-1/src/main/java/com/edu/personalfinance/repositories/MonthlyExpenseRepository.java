package com.edu.personalfinance.repositories;

import com.edu.personalfinance.models.MonthlyExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MonthlyExpenseRepository extends JpaRepository<MonthlyExpense, Long> {

    // Find expenses by username
    List<MonthlyExpense> findByJobDetailsUsername(String username);
}
