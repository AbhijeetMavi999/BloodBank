import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../service/user.service';
import { User } from '../user';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent implements OnInit {

  user = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  // registerForm() function for register the user
  registerUser() {    
    this.userService.registerUser(this.user)
    .subscribe(
      (data) => {
        if(data != null) {
          Swal.fire('User registered successfully', '', 'success')
          this.router.navigate(["/userlogin"])
        }
      },
      (error) =>{ 
        Swal.fire('User not registered', '', 'error');
        console.log(error);
      }
    );
  }

}
