import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent {
  selectedCity: string ="";
  venues: string[] = ['DLF', 'RIC'];
  selectedVenue: string = "";
  selectedCourt: string = "";
  selectedDate: string = "";
  minDate: string = "";
  maxDate: string = "";
  disableDate: boolean = true;
  courts: string[] = [];
  bookingSuccessful: boolean = false;

  onVenueChange() {
    // Simulating asynchronous data retrieval for courts based on selected venue
    setTimeout(() => {
      if (this.selectedVenue === 'DLF') {
        this.courts = ['Football', 'Badminton','Cafeteria', 'Work Cafe'];
      } else if (this.selectedVenue === 'RIC') {
        this.courts = ['Football', 'Badminton','Cafeteria', 'Work Cafe'];
      } else {
        this.courts = [];
      }
      this.selectedCourt = '';
    }, 500);
  }
  
//Start - This code is for enable 7 days
constructor() {
  const today = new Date();
  this.minDate = this.formatDate(today);

  const maxDate = new Date();
  maxDate.setDate(today.getDate() + 6);
  this.maxDate = this.formatDate(maxDate);
}

formatDate(date: Date): string {
  const year = date.getFullYear();
  const month = ('0' + (date.getMonth() + 1)).slice(-2);
  const day = ('0' + date.getDate()).slice(-2);
  return `${year}-${month}-${day}`;
}
//End - This code is for enable 7 days
onCourtChange() {
  this.selectedDate = '';
  this.disableDate = false;
}
//End - This code is for enable 7 Days
  bookVenue() {
    // Perform booking logic here
    this.bookingSuccessful = true;
  }


}

