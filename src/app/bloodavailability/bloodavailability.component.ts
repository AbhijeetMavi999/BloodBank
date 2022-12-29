import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserService } from '../service/user.service';
import { User } from '../user';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-bloodavailability',
  templateUrl: './bloodavailability.component.html',
  styleUrls: ['./bloodavailability.component.css'],
})
export class BloodavailabilityComponent implements OnInit {
  user = new User();
  receivedData: any[] = [];

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    console.log(this.receivedData.values.length);
  }

  checkBloodAvailability() {
    this.receivedData.push(
      this.userService
        .getBloodAvailability(this.user.state, this.user.bloodGroup)
        .subscribe(
          (data) => {
            if (data != 0) {
              Swal.fire('Yes, Blood is available');
            } else {
              Swal.fire({
                icon: 'error',
                title: 'Blood is not available',
                text: 'You want to submit request for blood?',
                confirmButtonText: 'Yes'
                // showConfirmButton: false,
              }).then(function () {
                (<any>window).location = '/submitbloodrequest';
              });
            }
          },
          (error) => {
            console.log(error);
          }
        )
    );
  }
}
