import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';   // Import FormsModule
import { CommonModule } from '@angular/common';  // Import CommonModule
import { RouterModule } from '@angular/router';  // Import RouterModule

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module'; // Import the routing module

// Import Standalone Components
import { JobDetailsComponent } from './jobdetails/jobdetails.component'; 
import { ExpenseComponent } from './expense/expense.component'; 
import { GraphComponent } from './graph/graph.component'; 

@NgModule({
  declarations: [
    AppComponent,
    // No need to declare standalone components here
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    RouterModule,
    AppRoutingModule,  // Ensure AppRoutingModule is imported
    JobDetailsComponent,
    ExpenseComponent,
    GraphComponent,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
