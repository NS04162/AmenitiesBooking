package com.citi.amenitiesbooking.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.citi.amenitiesbooking.entity.AmenitiesInfo;


@Mapper
public interface RicAmenitiesBookMapper {
	
	@Select("select * from RicAmenitiesInfo where amenitiesCode = #{code} and bookingDate = #{date} and currentAvailableCount > 0")
	AmenitiesInfo checkAvailability(int Code, Date date);
	
	@Update("update RicAmenitiesInfo set currentAvailableCount = currentAvailableCount - 1 where amenitiesCode = #{code} and bookingDate = #{date}")
	boolean bookAmenities(int code, Date date);

}