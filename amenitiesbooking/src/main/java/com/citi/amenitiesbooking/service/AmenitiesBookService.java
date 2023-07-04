package com.citi.amenitiesbooking.service;

import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.AmenitiesBookingResponse;

public interface AmenitiesBookService {
	
	AmenitiesBookingResponse book(AmenitiesBookingRequest request);

}
