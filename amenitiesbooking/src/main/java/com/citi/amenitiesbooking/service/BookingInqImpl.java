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
import com.citi.amenitiesbooking.model.BookingInqResponse;

@Component
public class BookingInqImpl implements BookingInqService{
	@Autowired
	BookingInqMapper bookingInqMapper;
	
	@Override
	public List<BookingInqResponse> bookInq(String loc, Date fromDate, Date toDate) {
		List<UserBookingInfo> userBookingInfoList=bookingInqMapper.findBookingInfoByLocation(loc, fromDate, toDate);
		Map<Date,Long> countMapper=userBookingInfoList.stream().collect(Collectors.
				groupingBy(UserBookingInfo::getBookingDate,Collectors.counting()));
		List<BookingInqResponse> resp = new ArrayList<BookingInqResponse>();
		for (UserBookingInfo userBookingInfo : userBookingInfoList) {
			Long countofCurrentBookingDate = countMapper.get(userBookingInfo.getBookingDate());
			System.out.println("count ->" + countofCurrentBookingDate);
			String amenityName = userBookingInfo.getBookedTurfNo().substring(4, 5);
			BookingInqResponse bookingInqResp=new BookingInqResponse(userBookingInfo.getBookingDate(),
					amenityName,userBookingInfo.getBookedTurfNo(),
					userBookingInfo.getEmailId(),countofCurrentBookingDate);
			resp.add(bookingInqResp);
			System.out.println("CUrrestResp --> " + bookingInqResp);
		}
		
		System.out.println(resp);
		return resp;
		
	}

}
