import { HttpClient } from '@angular/common/http';
import { Component,OnInit } from '@angular/core';


interface BookingInqRequest {

  location: string;
  fromDate: Date;
  toDate: Date

}

interface BookingInqResponse {
  // Define the properties of BookingInqResponse here
  bookingDate: Date,
  aminitesName: string,
  turfDetails: string,
  userDetails: string,
  count: number
}

@Component({
  selector: 'app-administrator',
  templateUrl: './administrator.component.html',
  styleUrls: ['./administrator.component.css']
})

export class AdministratorComponent {
  selectedVenue: string="";
 // response: string ="";
  response: { bookingDate: Date, aminitesName: string, turfDetails: string, userDetails: string, count: number }[] = [];
 // bookingDate: Date = new Date();
 
 venues: string[] = ['DLF', 'RIC'];
 fromDate: Date = new Date();
 toDate: Date = new Date();
  location: string ="";
  bookingDate: Date = new Date(0);
  aminitesName: string = ""; 
  turfDetails: string ="";
  userDetails: string = "";
  booking: string ="";
  displayedColumns: string =""
  showTable: boolean = false;

  constructor(private http: HttpClient) {}
  fetchData() {
    // Call the API or fetch data here
    // Once the response is received, assign it to the 'response' property
  //  this.response = // Assign the API response or fetched data
  
    // Set the 'showTable' property to true to show the table
    this.showTable = true;
  }
  bookingInquery() {
    const requestPayload: BookingInqRequest = {
      //amenitiesCode: this.amenitiesCode,
     // emailId: this.emailId,
    //  contactNo: this.contactNo,
      location: this.selectedVenue,
      fromDate: this.fromDate,
      toDate: this.toDate
    };
   // this.showTable = true;
    console.log("Inside bookingInquery(): Location==> " +this.location); // To get code from drop-down
    console.log("Inside bookingInquery: FromDate ==> " +this.fromDate);
    console.log("Inside bookingInquery: ToDate ==> " +this.toDate);
    this.http.post<BookingInqResponse[]>('http://localhost:8081/AminitiesBooking/bookingInq', requestPayload)
      .subscribe(
        (response) => {
          //console.log("Booking Inquery Location: " + requestPayload.location);
          console.log("Booking Inquery Response: ", response);
          this.response = response;
          console.log("After Assiging Inquery Response: ", this.response);
          // Handle the response as needed
        },
        (error) => {
          console.error("Error occurred: ", error);
          // Handle the error as needed
        }
      );
  }
}
