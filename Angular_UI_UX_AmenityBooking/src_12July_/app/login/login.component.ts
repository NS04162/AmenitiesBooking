import { Component, OnInit,Inject } from '@angular/core';
import { Router,ActivatedRoute  } from '@angular/router';
//import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AuthenticationService } from './auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit{
  userName: string = '';
  password : string = '';
  errorMessage : string = '';
  successMessage: string = '';
  loginFlag: boolean = false;
  invalidLogin = false;
  loginSuccess = false;
  //constructor(private router: Router, private http: HttpClient) {}
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    @Inject(AuthenticationService) private authenticationService: AuthenticationService,
    private http: HttpClient){}

  
  ngOnInit() {
  }
  
  login() {
    if (!this.userName || !this.password) {
      this.errorMessage = 'Please enter valid username and password.';
      return;
    }
    /*this.authenticationService.authenticationService(this.userName, this.password).subscribe((result)=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';
      this.router.navigate(['/dashboard']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    }); */
    this.authenticationService.authenticationService(this.userName, this.password).subscribe(
      (response: any) => {
        // Handle successful login response
        console.log(response.loginFlag);
        if(response.loginFlag == true){
            if (this.userName == 'admin'){
              this.authenticationService.isAuthenticated = true;
              this.router.navigate(['/administrator']);
            }
            else{
              this.successMessage = 'Login Successful.';
              this.authenticationService.isAuthenticated = true;
             this.router.navigate(['/dashboard']); 
            }
        
        }
      else if(response.loginFlag == false ){
        this.errorMessage = 'Incorrect userid  or password';
      return;
      }
        
      },
      error => {
        // Handle error response
        this.errorMessage = 'Invalid username or passwordasdsd.';
        console.error(error);
      }
    );
  }

  onRegister() {
    // Call your service method here
   //this.userService.registerUser(this.username, this.password, this.email);
   this.router.navigate(['/registration']);
 }
}


  
