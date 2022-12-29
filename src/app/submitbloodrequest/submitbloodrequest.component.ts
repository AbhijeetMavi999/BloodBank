import { Component, OnInit } from '@angular/core';
import { BloodRequirementTable } from '../bloodrequirementtable';
import { BloodrequiermenttableService } from '../service/bloodrequiermenttable.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-submitbloodrequest',
  templateUrl: './submitbloodrequest.component.html',
  styleUrls: ['./submitbloodrequest.component.css']
})
export class SubmitbloodrequestComponent implements OnInit {

  bloodRequest = new BloodRequirementTable();

  constructor(private bloodrequiermenttableService: BloodrequiermenttableService, private router: Router) { }

  ngOnInit(): void {
  }

  submitBloodRequest() {
    this.bloodrequiermenttableService.submitBloodRequest(this.bloodRequest)
    .subscribe(
      (data) => {
        if(data != null) {
          Swal.fire('Request submitted successfully', '', 'success')
          this.router.navigate(["/header"])
        }
      },
      (error) =>{ 
        Swal.fire('Request not submitted', '', 'error');
        console.log(error);
      }
    );
  }

}
