package com.citi.amenitiesbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.amenitiesbooking.entity.CustomerLoginInfo;
import com.citi.amenitiesbooking.mapper.CustomerLoginMapper;
import com.citi.amenitiesbooking.model.AmenitiesBookingRequest;
import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerLoginResponse;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	CustomerLoginMapper customerLoginMapper;

	@Override
	public CustomerLoginResponse login(CustomerLoginRequest request) {
		CustomerLoginResponse response = new CustomerLoginResponse();
		CustomerLoginInfo customerLoginInfo = customerLoginMapper.login(request.getUserName());
		if (customerLoginInfo != null) {
			
			if (customerLoginInfo.getUserName().equals(request.getUserName())) {
				if (customerLoginInfo.getPassword().equals(request.getPassword())) {  			
					response.setLoginFlag(true);
					response.setMessage("Logged in Successfully");
					return response;
				}

			}
			response.setLoginFlag(false);
			response.setMessage("username or password is invalid");
		}

		return response;


	}

}
