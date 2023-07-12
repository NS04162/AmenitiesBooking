import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
//import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RegistrationComponent } from './registration/registration.component';
//import { FacilitiesComponent } from './facilities/facilities.component';
//import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BookingComponent } from './booking/booking.component';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdministratorComponent } from './administrator/administrator.component';

import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTableModule } from '@angular/material/table';


const routes: Routes = [
  //{ path: '', component: WelcomeComponent },
  { path: '', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  {path: 'registration', component: RegistrationComponent},
  {path: 'administrator', component: AdministratorComponent},
  //{ path: 'facilities', component: FacilitiesCompo    nent },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
   // WelcomeComponent,
    LoginComponent,
    DashboardComponent,
    RegistrationComponent,
    BookingComponent,
    AdministratorComponent,
 
   // FacilitiesComponent,
  ],
  imports: [MatDatepickerModule, MatInputModule, MatNativeDateModule, BrowserModule, FormsModule, HttpClientModule, AppRoutingModule,
           MatButtonModule, MatFormFieldModule, MatInputModule, MatTableModule, RouterModule.forRoot(routes), BrowserAnimationsModule],
  providers: [  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
