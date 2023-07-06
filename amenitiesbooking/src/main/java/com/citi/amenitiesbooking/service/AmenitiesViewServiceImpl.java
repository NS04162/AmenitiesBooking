package com.citi.amenitiesbooking.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.amenitiesbooking.mapper.DlfAmenitiesViewMapper;
import com.citi.amenitiesbooking.mapper.RicAmenitiesViewMapper;
import com.citi.amenitiesbooking.model.AmenitiesBookingResponse;

@Service
public class AmenitiesViewServiceImpl implements AmenitiesViewService{

	@Autowired
	DlfAmenitiesViewMapper dlfAmenitiesViewMapper;

	@Autowired
	RicAmenitiesViewMapper ricAmenitiesViewMapper;
	

	@Override
	public AmenitiesBookingResponse viewAmenities(String location) {
		List<Map<String, Object>> amenitiesList=null;
		List<Map<String,Integer>> finalList = new ArrayList<>();
		
		if (location.equalsIgnoreCase("DLF"))
			amenitiesList = dlfAmenitiesViewMapper.viewAmenities();
		else
			amenitiesList = ricAmenitiesViewMapper.viewAmenities();
		
		AmenitiesBookingResponse response = new AmenitiesBookingResponse();
		Map<String, Integer> resultMap = new HashMap<>();
		if (amenitiesList != null) {
			for(Map<String,Object> entry:amenitiesList) {
				resultMap.put((String)entry.get("amenitiesName"), ((Number)entry.get("amenitiesCode")).intValue());

			}
			finalList.add(resultMap);
			response.setAvailableAmenities(finalList);
			return response;
		}
		
		return null;
	}


	

}
