package com.citi.amenitiesbooking.service;

import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerLoginResponse;

public interface LoginService {
	CustomerLoginResponse login(CustomerLoginRequest request);

}
