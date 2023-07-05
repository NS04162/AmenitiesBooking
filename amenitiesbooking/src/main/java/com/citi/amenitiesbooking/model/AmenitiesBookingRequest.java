package com.citi.amenitiesbooking.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AmenitiesBookingRequest {
	private int amenitiesCode;
	private Date bookingDate;
	private String emailId;
	private int contactNo;
	private String location;
	
	
	public AmenitiesBookingRequest() {
		super();
	}

	
	public AmenitiesBookingRequest(int amenitiesCode, Date bookingDate, String emailId, int contactNo,
			String location) {
		super();
		this.amenitiesCode = amenitiesCode;
		this.bookingDate = bookingDate;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.location = location;
	}


	public int getAmenitiesCode() {
		return amenitiesCode;
	}
	public void setAmenitiesCode(int amenitiesCode) {
		this.amenitiesCode = amenitiesCode;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "AmenitiesBookingRequest [amenitiesCode=" + amenitiesCode + ", bookingDate=" + bookingDate + ", emailId="
				+ emailId + ", contactNo=" + contactNo + ", location=" + location + "]";
	}
	
	
	
	
	
	

}
