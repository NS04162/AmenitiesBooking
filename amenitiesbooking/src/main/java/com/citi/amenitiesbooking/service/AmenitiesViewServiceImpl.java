package com.citi.amenitiesbooking.service;

import java.sql.Date;
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
		List<Map<Integer, String>> amenitiesList=null;
		
		if (location.equalsIgnoreCase("DLF"))
			amenitiesList = dlfAmenitiesViewMapper.viewAmenities();
		else
			amenitiesList = ricAmenitiesViewMapper.viewAmenities();
		
		AmenitiesBookingResponse response = new AmenitiesBookingResponse();
		if (amenitiesList != null) {
			response.setAvailableAmenities(amenitiesList);
			return response;
		}
		
		return null;
	}


	

}
