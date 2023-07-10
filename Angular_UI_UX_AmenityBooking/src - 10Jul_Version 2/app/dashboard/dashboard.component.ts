import { Component,OnInit } from '@angular/core';
//import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpParams } from '@angular/common/http';

interface Amenity {
  amenitiesName: string;
  amenitiesCode: number;
}
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  template: `
  <select (change)="handleOptionSelected($event)">
    <option *ngFor="let amenity of availableAmenities" [value]="amenity.amenitiesName">
      {{ amenity.amenitiesName }}
    </option>
  </select>
`

})

export class DashboardComponent implements OnInit {
  
  
  selectedCity: string ="";
  venues: string[] = ['DLF', 'RIC'];
  selectedVenue: string = "";
  selectedCourt: string = "";
  selectedDate: string = "";
  minDate: string = "";
  maxDate: string = "";
  disableDate: boolean = true;
  courts: { [key: string]: number }[] = [];
  availableAmenities: { amenitiesName: string, amenitiesCode: number }[] = [];
  bookingSuccessful: boolean = false;
  emailId: string = "DEFAULT";
  contactNo: number = 0;
  amenitiesName: string ="";
  amenitiesCode: number =0;
  bookingDate: Date = new Date();
  bookingDate1: Date = new Date();
  location: string = "";
  successMessage: string | null = null;
  errorMessage: string | null = null;
  successMessage1: string | null = null;
  errorMessage1: string | null = null;
  currentAvailableCount: number= 0;
  //constructor(private http: HttpClient) { }
  constructor(private http: HttpClient) {
    const today = new Date();
    this.minDate = this.formatDate(today);
  
    const maxDate = new Date();
    maxDate.setDate(today.getDate() + 6);
    this.maxDate = this.formatDate(maxDate);
  }
  ngOnInit(): void {
    this.onVenueChange();
  }

  onVenueChange() {
    // Simulating asynchronous data retrieval for courts based on selected venue
    setTimeout(() => {
      this.availableAmenities = [];
      if (this.selectedVenue === 'DLF') {
      //  this.courts = ['Football', 'Badminton','Cafeteria', 'Work Cafe'];
       // const selectedVenue = this.selectedVenue;

        this.http.get<any>('http://localhost:8081/AmenitiesBooking/Amenities/view', {
          params: {
            loc: this.selectedVenue
          }
        }).subscribe(
          (response) => {
            // Handle the success response
           console.log(" OnVenue Change " +response);
           
           if (Array.isArray(response.availableAmenities) && response.availableAmenities.length > 0) {
            const amenitiesObject = response.availableAmenities[0];
            this.availableAmenities = Object.entries(amenitiesObject).map(([amenitiesName, amenitiesCode]) => ({ amenitiesName, amenitiesCode })) as Amenity[];
          }
            // Extract details from the response array and assign it to the 'courts' property
           // this.courts = response;
          
            
          
          },
          (error) => {
            // Handle the error response
            console.error(error);
          }
        );
        
      } else if (this.selectedVenue === 'RIC') {
       // this.courts = ['Football', 'Badminton','Cafeteria', 'Work Cafe'];
       console.log("INSIDE RIC CODE");
       this.http.get<any>('http://localhost:8081/AmenitiesBooking/Amenities/view', {
          params: {
            loc: this.selectedVenue
          }
        }).subscribe(
          (response) => {
            // Handle the success response
           console.log(response);
           
           if (Array.isArray(response.availableAmenities) && response.availableAmenities.length > 0) {
            const amenitiesObject = response.availableAmenities[0];
            this.availableAmenities = Object.entries(amenitiesObject).map(([amenitiesName, amenitiesCode]) => ({ amenitiesName, amenitiesCode })) as Amenity[];
          }
            // Extract details from the response array and assign it to the 'courts' property
           // this.courts = response;
          
            
          
          },
          (error) => {
            // Handle the error response
            console.error(error);
          }
        );
      } else {
        this.courts = [];
      }
      this.selectedCourt = '';
    }, 500);
  }
  

  resetAvailableCount(): void {
    this.currentAvailableCount = 0;
  }
  checkAvailibility() {
    // Simulating asynchronous data retrieval for courts based on selected venue
    console.log("Inside checkAvailibility(): Amenities Code ==> " +this.amenitiesCode); // To get code from drop-down
    console.log("Inside checkAvailibility: bookingDate ==> " +this.bookingDate);
    console.log("Inside checkAvailibility: Location ==> " +this.location);
    if (true) {
      //  this.courts = ['Football', 'Badminton','Cafeteria', 'Work Cafe'];
       // const selectedVenue = this.selectedVenue;
       
       const requestPayload = {
        bookingDate: this.bookingDate,
        amenitiesCode: this.amenitiesCode,
        location: this.selectedVenue
      };

       this.http.post<any>('http://localhost:8081/AmenitiesBooking/Amenities/checkAvailability', requestPayload)
       .subscribe(
        (response) => {
          // Handle successful signup response
          //console.log(this.signupData.userName);
          console.log("InsidecheckAvailibility Response " +response);
          this.currentAvailableCount = response;
          if(response  > 0){
            this.successMessage1 = "";
            this.errorMessage ="";
            this.successMessage = 'Available for Booking';
          this.errorMessage = null;
         
          }
          else{
            this.successMessage1 = "";
            this.errorMessage = "";
            this.successMessage = "";
            this.errorMessage = 'Sorry! not available for booking';
          this.successMessage = null;
          
          }
        },
        (error) => {
          // Handle error response
          console.error(error);
          this.errorMessage = 'Sorry! not available for booking';
        }
      );
}
  }
//Start - This code is for enable 7 days


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

//START - Booking Amenities
handleOptionSelected(event: any) {
  // Do something with the selected value
   const selectedValue = event.target.value;
  if (selectedValue !== null) {
     
  console.log('Selected Amenity Code:', selectedValue);
  // Call another method and pass the selected value
  this.amenitiesCode = selectedValue;
  }
}
handleOptionSelectedDate(event: any) {
  // Do something with the selected value
   const selectedValue = event.target.value;
  if (selectedValue !== null) {
     
  console.log('Selected Date:', selectedValue);
  // Call another method and pass the selected value
  this.bookingDate = selectedValue;
  }
}
handleOptionSelectedVenue(event: any) {
  // Do something with the selected value
   const selectedValue = event.target.value;
  if (selectedValue !== null) {
     
  console.log('Selected Venue:', selectedValue);
  // Call another method and pass the selected value
  this.location = selectedValue;
  }
}


  bookVenue() {
    // Perform booking logic here
    
    console.log("Inside Book Venue(): Amenities Code ==> " +this.amenitiesCode); // To get code from drop-down
    console.log("Inside Book Venue(): bookingDate ==> " +this.bookingDate);
    console.log("Inside Book Venue(): Location ==> " +this.location);
    const requestPayload = {
      amenitiesCode: this.amenitiesCode,
      bookingDate: this.bookingDate,
      emailId: this.emailId,
      contactNo: this.contactNo,
      location: this.selectedVenue
    };
    // Call the registerUser method of the UserService
    this.http.post<any>('http://localhost:8081/AmenitiesBooking/Amenities/book', requestPayload)
      .subscribe(
        (response) => {
          // Handle successful signup response
          //console.log(this.signupData.userName);
          console.log("Inside booking code Response " +response.bookingFlag);
          if(response.bookingFlag == true){
            this.bookingSuccessful = true;
            this.successMessage1 = "";
            this.successMessage1 = 'Booking successful!';
          this.errorMessage = null;
         
          
          }
          else  if(response.bookingFlag == false){
            this.errorMessage = 'Booking Failed!';
          this.successMessage = null;
          }
        },
        (error) => {
          // Handle error response
          console.error(error);
        }
      );
     
}

  }
  //END - Booking Amenities

  


