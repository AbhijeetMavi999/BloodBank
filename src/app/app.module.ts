import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { SelectUserComponent } from './select-user/select-user.component';
import { MatCardModule } from '@angular/material/card';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UserregistrationComponent } from './userregistration/userregistration.component';
import {MatSelectModule} from '@angular/material/select';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { UserService } from './service/user.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BloodavailabilityComponent } from './bloodavailability/bloodavailability.component';
import { BloodrequirementtableComponent } from './bloodrequirementtable/bloodrequirementtable.component';
import { DonateBloodComponent } from './donate-blood/donate-blood.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { SubmitbloodrequestComponent } from './submitbloodrequest/submitbloodrequest.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SelectUserComponent,
    UserloginComponent,
    UserregistrationComponent,
    AdminloginComponent,
    BloodavailabilityComponent,
    BloodrequirementtableComponent,
    DonateBloodComponent,
    AdminhomeComponent,
    SubmitbloodrequestComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatCardModule,
    MatSelectModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],

  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
