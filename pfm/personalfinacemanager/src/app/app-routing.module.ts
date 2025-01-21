import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Import Components
import { HomeComponent } from './home/home.component'; // Standalone component
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { ExpenseComponent } from './expense/expense.component';
import { ContactComponent } from './contact/contact.component';
import { GraphComponent } from './graph/graph.component';
import { JobDetailsComponent } from './jobdetails/jobdetails.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent }, // Standalone component
  { path: 'about', component: AboutComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'expense', component: ExpenseComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'graph', component: GraphComponent },
  { path: 'jobdetails', component: JobDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
