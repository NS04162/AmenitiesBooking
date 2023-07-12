package com.citi.amenitiesbooking.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.amenitiesbooking.entity.UserBookingInfo;
import com.citi.amenitiesbooking.mapper.BookingInqMapper;
import com.citi.amenitiesbooking.model.BookingInqRequest;
import com.citi.amenitiesbooking.model.BookingInqResponse;

@Component
public class BookingInqImpl implements BookingInqService{
	@Autowired
	BookingInqMapper bookingInqMapper;
	
	@Override
	public List<BookingInqResponse> bookInq(BookingInqRequest bookingInqRequest) {
		
		List<UserBookingInfo> userBookingInfoList;
		
		if(bookingInqRequest.getFromDate() != null && bookingInqRequest.getToDate() != null ) {
			userBookingInfoList=bookingInqMapper.findBookingInfoByLocationAndDate(bookingInqRequest.getLocation(), bookingInqRequest.getFromDate(), bookingInqRequest.getToDate());
		}
		else {
			userBookingInfoList=bookingInqMapper.findBookingInfoByLocation(bookingInqRequest.getLocation());
		}
		
		Map<Date,Long> countMapper=userBookingInfoList.stream().collect(Collectors.
				groupingBy(UserBookingInfo::getBookingDate,Collectors.counting()));
		
		
		System.out.println("userBookingInfoList ->"+userBookingInfoList);
		System.out.println("countMapper ->"+countMapper);
		
		List<BookingInqResponse> resp = new ArrayList<>();
		
		for (UserBookingInfo userBookingInfo : userBookingInfoList) {
			Long countofCurrentBookingDate = countMapper.get(userBookingInfo.getBookingDate());
			String amenityName=userBookingInfo.getBookedTurfNo().substring(4, 5);
			String Cafe = "C";
			if(amenityName.equalsIgnoreCase("C")) {
				amenityName = "Cafe";
				
			}else if (amenityName.equalsIgnoreCase("F")) {
				amenityName = "Football";
			}else if (amenityName.equalsIgnoreCase("B")) {
				amenityName = "Badminton";
			}else
				amenityName = "WorkCafe";
			
			
			BookingInqResponse bookingInqResp=new BookingInqResponse(userBookingInfo.getBookingDate(),
					amenityName,userBookingInfo.getBookedTurfNo(),
					userBookingInfo.getEmailId(),countofCurrentBookingDate);
			
			resp.add(bookingInqResp);
		}
		
		System.out.println(resp);
		return resp;
		
	}

}
