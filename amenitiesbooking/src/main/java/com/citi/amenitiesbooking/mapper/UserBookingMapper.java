package com.citi.amenitiesbooking.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.citi.amenitiesbooking.entity.UserBookingInfo;

@Mapper
public interface UserBookingMapper {
	
	@Insert("insert into UserBookingInfo values (#{bookingId}, #{emailId}, #{bookedTurfNo}, #{contactNo})")
	int updateUser(String bookingId, String emailId, String bookedTurfNo, int contactNo);
		
	

}
