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
	
//	@Select("select bookingdate,substring(bookingID,6,1),substring(bookingid,2,6),emailID,1 from userbookinginfo where substring(bookingid,2,3)=#{location} and bookingDate between #{fromDate} and #{toDate}" )
	@Select("select * from userbookinginfo where substring(bookingid,2,3)=#{location} and bookingDate between #{fromDate} and #{toDate}" )
	List<UserBookingInfo> findBookingInfoByLocation(String location, Date fromDate, Date toDate);
	
//	@Select("select distinct bookingdate,count(*) from userbookinginfo where substring(bookingid,2,3)=#{location} and bookingDate between #{fromDate} and #{toDate} group by bookingdate")
//	@MapKey("bookingDate")
//	Map<Date,Integer> findBookingCountByLocation(String location, Date fromDate, Date toDate);
	

}
