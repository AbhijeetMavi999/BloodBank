import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserloginComponent } from './userlogin/userlogin.component';
import { SelectUserComponent } from './select-user/select-user.component';
import { UserregistrationComponent } from './userregistration/userregistration.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BloodavailabilityComponent } from './bloodavailability/bloodavailability.component';
import { BloodrequirementtableComponent } from './bloodrequirementtable/bloodrequirementtable.component';
import { DonateBloodComponent } from './donate-blood/donate-blood.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { SubmitbloodrequestComponent } from './submitbloodrequest/submitbloodrequest.component';
import { AuthGuard } from './service/auth.guard';


const routes: Routes = [
  { path: "", component: SelectUserComponent },
  { path: "userlogin", component: UserloginComponent },
  { path: "userregistration", component: UserregistrationComponent },
  { path: "adminlogin", component: AdminloginComponent },
  { path: "bloodavailability", component: BloodavailabilityComponent, canActivate: [AuthGuard] },
  { path: "bloodrequirementtable", component: BloodrequirementtableComponent, canActivate: [AuthGuard] },
  { path: "donateblood", component: DonateBloodComponent, canActivate: [AuthGuard] },
  { path: "adminhome", component: AdminhomeComponent, canActivate: [AuthGuard] },
  { path: "submitbloodrequest", component: SubmitbloodrequestComponent, canActivate: [AuthGuard] },
  { path: "header", component: HeaderComponent, canActivate: [AuthGuard] },
  { path: "footer", component: FooterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
