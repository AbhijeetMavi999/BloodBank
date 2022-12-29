import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BlooddonationService {

  constructor(private httpClient: HttpClient) { }

  // For Blood Donation
  public donateBlood(userData: any) {
    return this.httpClient.post("http://localhost:8083/donateblood/save",userData);
  }  
}
