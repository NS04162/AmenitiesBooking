package com.citi.amenitiesbooking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DlfAmenitiesViewMapper {
	
	@Select("select distinct amenitiesCode, amenitiesName from DLF_AmenitiesInfo")
	List<Map<Integer, String>> viewAmenities();

}
