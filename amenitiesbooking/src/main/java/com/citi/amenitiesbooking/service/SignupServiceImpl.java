package com.citi.amenitiesbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.amenitiesbooking.entity.CustomerLoginInfo;
import com.citi.amenitiesbooking.mapper.CustomerLoginMapper;
import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerSignupResponse;
import com.citi.amenitiesbooking.model.CustomerSignupRequest;
import com.citi.amenitiesbooking.model.CustomerSignupResponse;

@Service
public class SignupServiceImpl implements SignupService{

	@Autowired
	CustomerLoginMapper customerLoginMapper;

	@Override
	public CustomerSignupResponse signup(CustomerSignupRequest request) {
		CustomerSignupResponse response = new CustomerSignupResponse();
		CustomerLoginInfo customerLoginInfo = customerLoginMapper.login(request.getUserName());
		if (customerLoginInfo != null) {
			response.setSignupFlag(false);
			response.setMessage("username already exists");
			return response;
		}

		customerLoginMapper.signup(request.getUserName(),request.getPassword());
		response.setSignupFlag(true);
		response.setMessage("Sign up is done successfully");
		return response;


	}

}
