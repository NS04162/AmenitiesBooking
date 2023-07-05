package com.citi.amenitiesbooking.service;

import java.sql.Date;

import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.AmenitiesBookingResponse;

public interface AmenitiesBookService {
	
	AmenitiesBookingResponse book(AmenitiesBookingRequest request);
	int checkAvailability(String location, int amenitiesCode, Date bookingDate);

}
