import { Component, OnInit } from '@angular/core';
import { BloodDonation } from '../blooddonation';
import { BlooddonationService } from '../service/blooddonation.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-donate-blood',
  templateUrl: './donate-blood.component.html',
  styleUrls: ['./donate-blood.component.css'],
})
export class DonateBloodComponent implements OnInit {
  blooddonation = new BloodDonation();

  constructor(
    private blooddonationService: BlooddonationService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  donateBlood() {
    this.blooddonationService.donateBlood(this.blooddonation).subscribe(
      (response) => {
        if (response != null) {
          Swal.fire('We will schedule your slot, You are going to save a life', '','success');
          this.router.navigate(['/header']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
