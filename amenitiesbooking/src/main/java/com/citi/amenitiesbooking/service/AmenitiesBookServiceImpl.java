package com.citi.amenitiesbooking.service;

import java.sql.Date;
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

				userBookingMapper.updateUser(bookingId,request.getEmailId(),turfNo, request.getContactNo());
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
		if (location.equalsIgnoreCase("DLF")) {
			Date minBookingdate = dlfAmenitiesBookMapper.checkBookingDate();
			long dateDiff = ChronoUnit.DAYS.between(minBookingdate.toLocalDate(),bookingDate.toLocalDate());
			if (dateDiff == 8)
				updateAvailability(location);
		
			return dlfAmenitiesBookMapper.checkAvailability(amenitiesCode, bookingDate).getCurrentAvailableCount();
		}
		else {
			Date minBookingdate = ricAmenitiesBookMapper.checkBookingDate();
			long dateDiff = ChronoUnit.DAYS.between(minBookingdate.toLocalDate(),bookingDate.toLocalDate());
			if (dateDiff == 8)
				updateAvailability(location);
		
			return ricAmenitiesBookMapper.checkAvailability(amenitiesCode, bookingDate).getCurrentAvailableCount();
		}

	}

	private void updateAvailability(String location) {
		
		if (location.equalsIgnoreCase("DLF"))
			dlfAmenitiesBookMapper.updateAmenitiesInfo();
		else
			ricAmenitiesBookMapper.updateAmenitiesInfo();

	}

}
