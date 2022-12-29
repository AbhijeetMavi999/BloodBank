import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  // For User Login
  public getUserByEmailAndPassword(email: string, password: string) {
    // console.log(email, password);
    return this.httpClient.get("http://localhost:9191/user/"+email+"/"+password);    
  }

  // For User Registration
  public registerUser(userData: any) {
    return this.httpClient.post("http://localhost:8081/user/register",userData);
  }

  // For Blood Availability
  public getBloodAvailability(state: string, bloodGroup: string) {
    return this.httpClient.get("http://localhost:8081/user/checkblood"+"/"+state+"/"+bloodGroup);
  }

  // For getting all the users
  public getAllUsers() {
    return this.httpClient.get("http://localhost:8081/user/all");
  }
}
