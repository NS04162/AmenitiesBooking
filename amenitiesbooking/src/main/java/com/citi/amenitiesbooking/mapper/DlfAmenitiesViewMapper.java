package com.citi.amenitiesbooking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DlfAmenitiesViewMapper {
	
	@Select("select distinct amenitiesName, amenitiesCode from DLF_AmenitiesInfo")
	@MapKey("amenitiesName")
	List<Map<String, Object>> viewAmenities();

}
