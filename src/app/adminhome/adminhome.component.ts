import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../user';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css'],
})
export class AdminhomeComponent implements OnInit {
  users: any = [];

  constructor(private userService: UserService, private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe((data) => {
      this.users = data;
    });
  }

  logOut() {
    Swal.fire('LogOut Successfull', '', 'success');
    this.authService.removeToken();
    this.router.navigate(['/']);
  }

  checkBloodRequirement() {
    this.router.navigate(['/bloodrequirementtable']);
  }
}
