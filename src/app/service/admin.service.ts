import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }

  public getAdminByEmailAndPassword(adminId: string, adminPassword: string) {
    // const username = 'abhijeet';
    // const password = 'password'
    // const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)});
    return this.httpClient.get("http://localhost:9191/admin/"+adminId+"/"+adminPassword);  
    
    // {headers,responseType:'text' as 'json'}
  }
}
