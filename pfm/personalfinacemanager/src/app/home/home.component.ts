import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'], // Ensure this path is correct
})
export class HomeComponent {
  // Properties for dynamic data binding
  title: string = 'Welcome to Dreampay!';
  description: string =
    'Personal finance management made simple. Create a plan for income, expenses, and investments to achieve your financial goals.';
  ctaPrimary: string = 'Get Started';
  ctaSecondary: string = 'Read More';

  constructor(private router: Router) {}

  // Methods for button actions
  onPrimaryClick(): void {
    console.log('Get Started button clicked!');
    this.router.navigate(['/register']); // Navigate to the 'register' route
  }

  onSecondaryClick(): void {
    console.log('Read More button clicked!');
    // Add redirection logic if required
  }
}
