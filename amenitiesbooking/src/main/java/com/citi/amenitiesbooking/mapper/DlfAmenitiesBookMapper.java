package com.citi.amenitiesbooking.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.citi.amenitiesbooking.entity.AmenitiesInfo;

@Mapper
public interface DlfAmenitiesBookMapper {
	
	@Select("select * from DLF_AmenitiesInfo  where amenitiesCode = #{code} and bookingDate = #{date} and currentAvailableCount > 0")
	AmenitiesInfo checkAvailability(int code, Date date);
	
	@Update("update DLF_AmenitiesInfo  set currentAvailableCount = currentAvailableCount - 1 where amenitiesCode = #{code} and bookingDate = #{date}")
	boolean bookAmenities(int code, Date date);

}
