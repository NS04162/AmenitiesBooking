package com.citi.amenitiesbooking.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.citi.amenitiesbooking.mapper.CustomerLoginMapper;
import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerLoginResponse;

public class LoginServiceImpl implements LoginService{
	
	@Autowired
	CustomerLoginMapper customerLoginMapper;

	@Override
	public CustomerLoginResponse login(CustomerLoginRequest request) {
		
//		customerLoginMapper.login(request);
		// TODO Auto-generated method stub
		return null;
		
		
	}

}
