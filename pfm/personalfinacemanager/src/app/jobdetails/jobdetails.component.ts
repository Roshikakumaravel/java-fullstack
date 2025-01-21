import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';  // Import CommonModule here
import { FormsModule } from '@angular/forms';   // Import FormsModule here
import { RouterModule } from '@angular/router';  // Import RouterModule here

@Component({
  selector: 'app-jobdetails',
  templateUrl: './jobdetails.component.html',
  styleUrls: ['./jobdetails.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],  // Add imports directly here
})
export class JobDetailsComponent {
  job: string = '';
  salary: number = 0;

  constructor(private router: Router) {}

  submitJobDetails() {
    // Save job and salary to localStorage
    localStorage.setItem('job', this.job);
    localStorage.setItem('salary', this.salary.toString());
    this.router.navigate(['/expense']);
  }
}
