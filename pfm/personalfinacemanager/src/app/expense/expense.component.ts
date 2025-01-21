import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';  // Import CommonModule here
import { FormsModule } from '@angular/forms';   // Import FormsModule here
import { RouterModule } from '@angular/router';  // Import RouterModule here

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],  // Add imports directly here
})
export class ExpenseComponent {
  expenseCategories: string[] = ['Food', 'Rent', 'Medical', 'Education', 'Miscellaneous'];
  expenses: { [key: string]: number } = {};

  constructor(private router: Router) {}

  submitExpenses() {
    // Save the expenses to localStorage
    localStorage.setItem('expenses', JSON.stringify(this.expenses));
    this.router.navigate(['/graph']);
  }
}
