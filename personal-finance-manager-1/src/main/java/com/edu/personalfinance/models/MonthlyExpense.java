package com.edu.personalfinance.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "monthly_expenses")
public class MonthlyExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private JobDetails jobDetails;

    @Column(nullable = false)
    private double food;

    @Column(nullable = false)
    private double rent;

    @Column(nullable = false)
    private double medical;

    @Column(nullable = false)
    private double education;

    @Column(nullable = false)
    private double miscellaneous;

    @Column(nullable = false)
    private LocalDate date;  // Date of the expense record

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobDetails getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(JobDetails jobDetails) {
        this.jobDetails = jobDetails;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getMedical() {
        return medical;
    }

    public void setMedical(double medical) {
        this.medical = medical;
    }

    public double getEducation() {
        return education;
    }

    public void setEducation(double education) {
        this.education = education;
    }

    public double getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(double miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
