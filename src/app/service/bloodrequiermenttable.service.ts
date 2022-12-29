import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BloodRequirementTable } from '../bloodrequirementtable';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
  providedIn: 'root'
})
export class BloodrequiermenttableService {

  constructor(private httpClient: HttpClient) { }

  // For getting the all Blood Requirements
  public listOfBloodRequirements() {
    return this.httpClient.get("http://localhost:8082/bloodrequirement/all");
  }

  // For Submitting blood request
  public submitBloodRequest(data: any) {
    return this.httpClient.post("http://localhost:8082/bloodrequirement/save", data);
  }

  // For deleting by Id
  public deleteById(id: number) {
    return this.httpClient.delete("http://localhost:8082/bloodrequirement/delete/"+id);
  }
}
