package com.citi.amenitiesbooking.model;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CustomerLoginRequest {
	
	private String userName;
	private String password;
	
	public CustomerLoginRequest() {
		super();
	}

	public CustomerLoginRequest(String userName, String password) {
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

	@Override
	public String toString() {
		return "CustomerLoginRequest [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	

	
	
	

}
