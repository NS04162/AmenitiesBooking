package com.citi.amenitiesbooking.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.citi.amenitiesbooking.model.BookingInqRequest;
import com.citi.amenitiesbooking.model.BookingInqResponse;

@Service
public interface BookingInqService {
	List<BookingInqResponse> bookInq(BookingInqRequest bookingInqRequest);
}
