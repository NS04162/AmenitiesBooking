package com.citi.amenitiesbooking.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.AmenitiesBookingResponse;
import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerLoginResponse;
import com.citi.amenitiesbooking.model.CustomerSignupRequest;
import com.citi.amenitiesbooking.model.CustomerSignupResponse;
import com.citi.amenitiesbooking.service.AmenitiesBookServiceImpl;
import com.citi.amenitiesbooking.service.AmenitiesViewServiceImpl;
import com.citi.amenitiesbooking.service.LoginServiceImpl;
import com.citi.amenitiesbooking.service.SignupServiceImpl;

@RestController

@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class AmenitiesBookingController {

	
	@Autowired
	private AmenitiesViewServiceImpl amenitiesViewService;

	@Autowired
	private AmenitiesBookServiceImpl amenitiesBookService;

	@Autowired
	private LoginServiceImpl loginService;

	@Autowired
	private SignupServiceImpl signupService;

	@PostMapping("AmenitiesBooking/Login")
	public ResponseEntity<CustomerLoginResponse> login(@RequestBody CustomerLoginRequest request){
		System.out.println(request);
		CustomerLoginResponse response= null;
		if (request != null) {

			response = loginService.login(request);
			if (response != null) {
				return new ResponseEntity<CustomerLoginResponse>(response, HttpStatus.OK);
			}

		}
		return new ResponseEntity<CustomerLoginResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("AmenitiesBooking/signup")
	public ResponseEntity<CustomerSignupResponse> signup(@RequestBody CustomerSignupRequest request){

		CustomerSignupResponse response = new CustomerSignupResponse();
		if (request != null) {
			response = signupService.signup(request);
			return new ResponseEntity<CustomerSignupResponse>(response, HttpStatus.OK);
		}

		return new ResponseEntity<CustomerSignupResponse>(response, HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("AmenitiesBooking/Amenities/view")
	public ResponseEntity<AmenitiesBookingResponse> viewAmenities(@RequestParam ("loc") String location){
		AmenitiesBookingResponse response = amenitiesViewService.viewAmenities(location);
		if (response != null) {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

	}

	@PostMapping("AmenitiesBooking/Amenities/checkAvailability")
	public int checkAvailability(@RequestBody AmenitiesBookingRequest request) {
		if (!request.getLocation().isEmpty() && request.getBookingDate() != null) {
			return amenitiesBookService.checkAvailability(request.getLocation(), request.getAmenitiesCode(), request.getBookingDate());
		}
		return 0;
	}
	
	@PostMapping("AmenitiesBooking/Amenities/book")
	public ResponseEntity<AmenitiesBookingResponse> bookAmenities(@RequestBody AmenitiesBookingRequest request){
		System.out.println(request);
		AmenitiesBookingResponse response = null;
		if (request != null) {
			response = amenitiesBookService.book(request);
			if (response != null)
				return new ResponseEntity<>(response,HttpStatus.OK);						

		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

}
