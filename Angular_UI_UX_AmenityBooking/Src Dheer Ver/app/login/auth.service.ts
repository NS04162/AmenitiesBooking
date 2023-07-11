import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  //BASE_PATH: 'http://localhost:8081'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public userName: String ='';
  public password: String = '';
  public isAuthenticated = false;

  constructor(private http: HttpClient) {

  }

  authenticationService(userName: String, password: String) {
    const loginData = { userName, password };
    return this.http.post(`http://localhost:8081/AmenitiesBooking/Login`, loginData);
    /*return this.http.get(`http://localhost:8081/AmenitiesBooking/Login`,
      { headers: { authorization: this.createBasicAuthToken(userName, password) } }).pipe(map((res) => {
        this.userName = userName;
        this.password = password;
        this.registerSuccessfulLogin(userName, password);
      }));*/
  }

  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username: String, password: String) {
    //sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
//    this.username = null;
 //   this.password = null;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }

  setIsAuthenticated(value: boolean) {
    this.isAuthenticated = value;
  }

  getIsAuthenticated(): boolean {
    return this.isAuthenticated;
  }
}