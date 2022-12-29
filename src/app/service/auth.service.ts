import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  // For setting the token
  setToken(token: string) {
    localStorage.setItem('access_token', token);
  }

  // For deleting the token
  removeToken() {
    return localStorage.removeItem('access_token');
  }

  // Return true if login else false
  isLoggedin(): boolean {
    return localStorage.getItem("access_token") ? true : false;
  }
}
