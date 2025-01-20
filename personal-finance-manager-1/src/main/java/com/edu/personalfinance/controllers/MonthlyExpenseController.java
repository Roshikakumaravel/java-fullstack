package com.edu.personalfinance.controllers;

import com.edu.personalfinance.models.MonthlyExpense;
import com.edu.personalfinance.services.MonthlyExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class MonthlyExpenseController {

    @Autowired
    private MonthlyExpenseService monthlyExpenseService;

    // Add a new monthly expense for a user
    @PostMapping("/{username}/add")
    public ResponseEntity<String> addMonthlyExpense(@PathVariable String username, @RequestBody MonthlyExpense monthlyExpense) {
        try {
            monthlyExpenseService.addMonthlyExpense(username, monthlyExpense);
            return ResponseEntity.ok("Monthly expense added successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // Get all monthly expenses for a user
    @GetMapping("/{username}")
    public ResponseEntity<List<MonthlyExpense>> getMonthlyExpenses(@PathVariable String username) {
        List<MonthlyExpense> expenses = monthlyExpenseService.getMonthlyExpensesByUsername(username);
        return ResponseEntity.ok(expenses);
    }
}
