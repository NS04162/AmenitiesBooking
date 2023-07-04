package com.citi.amenitiesbooking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AmenitiesViewMapper {
	
	@Select("select distinct amenitiesName from AmenitiesInfo")
	List<String> viewAmenities();

}
