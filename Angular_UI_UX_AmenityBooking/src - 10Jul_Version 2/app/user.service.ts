import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'your_backend_registration_endpoint';

  constructor(private http: HttpClient) {}

  registerUser(username: string, password: string, email: string) {
    const user = { username, password, email };
    return this.http.post(`${this.apiUrl}/register`, user);
  }

  authenticate(username: string, password: string){
    const body = { username, password };
    return this.http.post(`${this.apiUrl}/login`, body);
  }
}
