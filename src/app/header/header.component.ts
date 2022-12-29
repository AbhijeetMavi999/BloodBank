import { Component, OnInit } from '@angular/core';
import { BloodRequirementTable } from '../bloodrequirementtable';
import { BloodrequiermenttableService } from '../service/bloodrequiermenttable.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {

  bloodRequirementTables: any = [];
  
  constructor(private bloodrequiermenttableService : BloodrequiermenttableService, private router: Router,
    private authService: AuthService) {}

  ngOnInit(): void {
    this.listOfBloodRequirements();
  }

  // getting all the blood requirements
  listOfBloodRequirements() {
    this.bloodrequiermenttableService.listOfBloodRequirements().subscribe(
      data => {
        this.bloodRequirementTables = data;
      }
    )
  } 

  // For user log out
  logout() {
    Swal.fire('Logout Successfully', '', 'success');
    this.authService.removeToken();
    this.router.navigate(['/userlogin']);
  }
}
