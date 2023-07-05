import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login() {
    // Perform login logic (e.g., validate credentials)
    // For simplicity, let's assume successful login and navigate to the dashboard
     // Perform login logic here
     console.log('Login clicked');
     console.log('Username:', this.username);
     console.log('Password:', this.password);
    this.router.navigate(['/dashboard']);
  }
}
