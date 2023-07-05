package com.citi.amenitiesbooking.model;

public class CustomerSignupResponse {
	
	private String message;
	private boolean signupFlag;
	
	public CustomerSignupResponse() {
		super();
	}	
	
	public CustomerSignupResponse(String message, boolean loginFlag) {
		super();
		this.message = message;
		this.signupFlag = loginFlag;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSignupFlag() {
		return signupFlag;
	}

	public void setSignupFlag(boolean signupFlag) {
		this.signupFlag = signupFlag;
	}



}
