package com.citi.amenitiesbooking.model;

public class CustomerSignupRequest {
	
	private String userName;
	private String password;
	
	public CustomerSignupRequest() {
		super();
	}
	
		public CustomerSignupRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
