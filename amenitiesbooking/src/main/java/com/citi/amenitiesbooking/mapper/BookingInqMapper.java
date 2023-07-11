package com.citi.amenitiesbooking.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.citi.amenitiesbooking.entity.UserBookingInfo;

@Mapper
public interface BookingInqMapper {
	
	@Select("select * from userbookinginfo where substring(bookingid,2,3)=#{location} and bookingDate between #{fromDate} and #{toDate}" )
	List<UserBookingInfo> findBookingInfoByLocationAndDate(String location, Date fromDate, Date toDate);

	@Select("select * from userbookinginfo where substring(bookingid,2,3)=#{location}" )
	List<UserBookingInfo> findBookingInfoByLocation(String location);
	
//	@Select("select distinct amenitiescode,amenitiesname from DLF_amenitiesinfo" )
//	List<Map<Integer ,String>> findDlfAmenities();
}
