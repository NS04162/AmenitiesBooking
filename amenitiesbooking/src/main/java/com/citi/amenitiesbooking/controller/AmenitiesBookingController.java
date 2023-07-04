package com.citi.amenitiesbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.AmenitiesBookingResponse;
import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerLoginResponse;
import com.citi.amenitiesbooking.service.AmenitiesBookServiceImpl;
import com.citi.amenitiesbooking.service.AmenitiesViewServiceImpl;
import com.citi.amenitiesbooking.service.LoginServiceImpl;

@RestController
public class AmenitiesBookingController {
	
	@Autowired
	private AmenitiesViewServiceImpl amenitiesViewService;
	
	@Autowired
	private AmenitiesBookServiceImpl amenitiesBookService;
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@RequestMapping("AmenitiesBooking/Login")
	public ResponseEntity<CustomerLoginResponse> login(CustomerLoginRequest request){
		
		CustomerLoginResponse response = loginService.validate(request);
		if (response != null) {
			return new ResponseEntity<CustomerLoginResponse>(response, HttpStatus.OK);
		}
		
		return new ResponseEntity<CustomerLoginResponse>(response, HttpStatus.BAD_REQUEST);
	}

	
	@RequestMapping("AmenitiesBooking/Amenities/view")
	public ResponseEntity<AmenitiesBookingResponse> viewAmenities(){
		AmenitiesBookingResponse response = amenitiesViewService.view();
		if (response != null) {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping("AmenitiesBooking/Amenities/book")
	public ResponseEntity<AmenitiesBookingResponse> bookAmenities(AmenitiesBookingRequest request){
		AmenitiesBookingResponse response = amenitiesBookService.book();
		if (response != null)
			return new ResponseEntity<>(response,HttpStatus.OK);
		else
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}

}
