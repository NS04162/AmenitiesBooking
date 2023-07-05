package com.citi.amenitiesbooking.service;

import com.citi.amenitiesbooking.model.CustomerLoginRequest;
import com.citi.amenitiesbooking.model.CustomerLoginResponse;
import com.citi.amenitiesbooking.model.CustomerSignupRequest;
import com.citi.amenitiesbooking.model.CustomerSignupResponse;

public interface SignupService {
	CustomerSignupResponse signup(CustomerSignupRequest request);

}
