package com.citi.amenitiesbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CustomerLoginResponse {
	
	private String message;
	private boolean loginFlag;
	
	public CustomerLoginResponse() {
		super();
	}

	public CustomerLoginResponse(String message, boolean loginFlag) {
		super();
		this.message = message;
		this.loginFlag = loginFlag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	
	
	
	

}
