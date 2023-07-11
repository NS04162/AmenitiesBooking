package com.citi.amenitiesbooking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RicAmenitiesViewMapper {
	
	@Select("select distinct amenitiesName, AmenitiesCode from RicAmenitiesInfo")
	List<Map<String, Object>> viewAmenities();

}
