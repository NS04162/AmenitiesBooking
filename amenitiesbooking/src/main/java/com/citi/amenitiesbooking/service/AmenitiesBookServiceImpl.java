package com.citi.amenitiesbooking.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.amenitiesbooking.entity.AmenitiesInfo;
import com.citi.amenitiesbooking.mapper.DlfAmenitiesBookMapper;
import com.citi.amenitiesbooking.mapper.RicAmenitiesBookMapper;
import com.citi.amenitiesbooking.mapper.UserBookingMapper;
import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.AmenitiesBookingResponse;

@Service
public class AmenitiesBookServiceImpl implements AmenitiesBookService{

	@Autowired
	DlfAmenitiesBookMapper dlfAmenitiesBookMapper;

	@Autowired
	RicAmenitiesBookMapper ricAmenitiesBookMapper;

	@Autowired
	UserBookingMapper userBookingMapper;

	@Override
	public AmenitiesBookingResponse book(AmenitiesBookingRequest request) {

		AmenitiesBookingResponse response = new AmenitiesBookingResponse();
		AmenitiesInfo amenitiesInfo= null;

		if (request != null) {
			if (request.getLocation().equalsIgnoreCase("DLF")) 	
				amenitiesInfo = dlfAmenitiesBookMapper.checkAvailability(request.getAmenitiesCode(), request.getBookingDate());
			
			else 
				amenitiesInfo = ricAmenitiesBookMapper.checkAvailability(request.getAmenitiesCode(), request.getBookingDate());

			if (amenitiesInfo != null) {
				int count = (amenitiesInfo.getTotalCount() - amenitiesInfo.getCurrentAvailableCount()) + 1;
				String turfNo = request.getLocation() + "-" + amenitiesInfo.getAmenitiesName().charAt(0) + count;
				String bookingId = amenitiesInfo.getAmenitiesCode() + turfNo + amenitiesInfo.getBookingDate().toString();
				if (request.getLocation().equalsIgnoreCase("DLF")) 
					dlfAmenitiesBookMapper.bookAmenities(request.getAmenitiesCode(), request.getBookingDate());
				else
					ricAmenitiesBookMapper.bookAmenities(request.getAmenitiesCode(), request.getBookingDate());

				userBookingMapper.updateUser(bookingId,request.getEmailId(),turfNo, request.getContactNo(),request.getBookingDate());
				response.setAmenityTurfDetail(turfNo);
				response.setBookingFlag(true);
				response.setBookingId(bookingId);
				return response;
			}

		}
		response.setBookingFlag(false);
		return response;

	}

	@Override
	public int checkAvailability(String location, int amenitiesCode, Date bookingDate) {
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date currentDate = new java.util.Date();
		
		System.out.println("date :: "+sdFormat.format(currentDate));
		Date sqlDate = new Date (currentDate.getTime());

		if (location.equalsIgnoreCase("DLF")) {				
		    updateAvailability(location,sqlDate);
		
			return dlfAmenitiesBookMapper.checkAvailability(amenitiesCode, bookingDate).getCurrentAvailableCount();
		}
		else {
				updateAvailability(location,sqlDate);
		
			return ricAmenitiesBookMapper.checkAvailability(amenitiesCode, bookingDate).getCurrentAvailableCount();
		}

	}

	private void updateAvailability(String location, Date currentDate) {
		
		if (location.equalsIgnoreCase("DLF"))
			dlfAmenitiesBookMapper.updateAmenitiesInfo(currentDate);
		else
			ricAmenitiesBookMapper.updateAmenitiesInfo(currentDate);

	}

}
