import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../service/admin.service';
import Swal from 'sweetalert2';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  admin = new Admin();

  constructor(private adminService: AdminService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  loginAdmin() {
    this.adminService
      .getAdminByEmailAndPassword(this.admin.adminId, this.admin.adminPassword)
      .subscribe(
        (data) => {
          if(data != null) {
            Swal.fire('Login Successful', '', 'success')
            this.authService.setToken(data.toString());
            this.router.navigate(['/adminhome']);
          }
        },
        (error) => {
          Swal.fire('adminId or password is incorrect', '', 'error');
          console.log(error);
        }
      );
  }

}
