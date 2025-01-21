import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js/auto'; // Import Chart.js

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {
  salary: number = 50000; // Example salary
  expenses: number[] = [1000, 2000, 3000, 4000, 5000]; // Example expenses array
  totalExpenses: number = 0; // Initialize total expenses
  balance: number = 0; // Initialize balance (savings)

  constructor() {}

  ngOnInit(): void {
    this.calculateTotalExpenses();
    this.calculateSavings();
    this.createGraph();
  }

  calculateTotalExpenses(): void {
    this.totalExpenses = this.expenses.reduce((acc, expense) => acc + expense, 0);
  }

  calculateSavings(): void {
    this.balance = this.salary - this.totalExpenses;
  }

  createGraph(): void {
    const ctx = document.getElementById('expenseChart') as HTMLCanvasElement;

    new Chart(ctx, {
      type: 'bar', // Bar chart
      data: {
        labels: ['Expense 1', 'Expense 2', 'Expense 3', 'Expense 4', 'Expense 5'], // Labels for each expense
        datasets: [
          {
            label: 'Expenses',
            data: this.expenses, // Data for expenses
            backgroundColor: 'rgba(75, 192, 192, 0.5)', // Bar color
            borderColor: 'rgba(75, 192, 192, 1)', // Border color
            borderWidth: 1
          }
        ]
      },
      options: {
        responsive: true,
        plugins: {
          legend: {
            position: 'top'
          },
          title: {
            display: true,
            text: 'Expense Breakdown'
          }
        },
        scales: {
          y: {
            beginAtZero: true // Ensure the y-axis starts at 0
          }
        }
      }
    });
  }
}
