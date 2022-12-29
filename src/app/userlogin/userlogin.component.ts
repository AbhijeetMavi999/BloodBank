import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { User } from '../user';
import Swal from 'sweetalert2';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css'],
})
export class UserloginComponent implements OnInit {
  user = new User();

  constructor(private userService: UserService, private router: Router,
     private authService: AuthService) {}

  ngOnInit(): void {}

  // loginUser() function for user login
  loginUser() {
    this.userService
      .getUserByEmailAndPassword(this.user.email, this.user.password)
      .subscribe(
        (data) => {
          if (data != null) {
            Swal.fire('Welcome back', '', 'success');
            this.authService.setToken(data.toString());
            this.router.navigate(['/header']);
          }
        },
        (error) => {
          Swal.fire('username or password is incorrect', '', 'error');
          console.log(error);
        }
      );
  }
}
