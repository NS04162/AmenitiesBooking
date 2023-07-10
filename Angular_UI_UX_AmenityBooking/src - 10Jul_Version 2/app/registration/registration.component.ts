import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  signupData = {
  userName:  '',
  password :  ''
  };
  signupFlag: boolean = false;
  successMessage: string | null = null;
  errorMessage: string | null = null;


  //constructor(@Inject(UserService) private userService: UserService) {}
  constructor(private http: HttpClient) {}
  onRegister() {
    const requestPayload = {
      userName: this.signupData.userName,
      password: this.signupData.password
    };

    // Call the registerUser method of the UserService
    this.http.post<any>('http://localhost:8081/AmenitiesBooking/signup', requestPayload)
      .subscribe(
        (response) => {
          // Handle successful signup response
          console.log(this.signupData.userName);
          console.log(response);
          if(response.signupFlag == true){
            this.successMessage = 'Signup successful!';
          this.errorMessage = null;
          }
          else   if(response.signupFlag == false){
            this.errorMessage = 'Signup Failed!';
          this.successMessage = null;
          }
        },
        (error) => {
          // Handle error response
          console.error(error);
        }
      );
}
}
