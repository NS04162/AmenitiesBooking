import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
//import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
//import { FacilitiesComponent } from './facilities/facilities.component';

const routes: Routes = [
  //{ path: '', component: WelcomeComponent },
  { path: '', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  //{ path: 'facilities', component: FacilitiesComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
   // WelcomeComponent,
    LoginComponent,
    DashboardComponent,
   // FacilitiesComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
