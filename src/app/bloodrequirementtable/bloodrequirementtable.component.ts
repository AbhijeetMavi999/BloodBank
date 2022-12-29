import { Component, OnInit } from '@angular/core';
import { BloodrequiermenttableService } from '../service/bloodrequiermenttable.service';
import { BloodRequirementTable } from '../bloodrequirementtable';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bloodrequirementtable',
  templateUrl: './bloodrequirementtable.component.html',
  styleUrls: ['./bloodrequirementtable.component.css']
})
export class BloodrequirementtableComponent implements OnInit {

  bloodRequirementTables: any = [];

  constructor(private bloodrequiermenttableService : BloodrequiermenttableService, private router: Router) { }

  ngOnInit(): void {
    this.listOfBloodRequirements();
  }

  listOfBloodRequirements() {
    this.bloodrequiermenttableService.listOfBloodRequirements().subscribe(
      data => {
        this.bloodRequirementTables = data;
      }
    )
  } 

  deleteById(id: number) {
    this.bloodrequiermenttableService.deleteById(id).subscribe(
      data => {
        Swal.fire('Deleted', 'Blood Requirement delete successfully', 'success')
        .then(function () {
          (<any>window).location = '/bloodrequirementtable';
        });
        // console.log(data);
      },
      error => {
        console.log(error);
        Swal.fire('Not Deleted', '', 'error');
      }
    )
  }
}
