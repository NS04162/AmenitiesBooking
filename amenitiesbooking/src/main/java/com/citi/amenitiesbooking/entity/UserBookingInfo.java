package com.citi.amenitiesbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserBookingInfo {
	private String bookingId;
	private String emailId;
	private String bookedTurfNo;
	private int contactNo;
	
	
	public UserBookingInfo() {
		super();
	}
	
	public UserBookingInfo(String bookingId, String emailId, String bookedTurfNo, int contactNo) {
		super();
		this.bookingId = bookingId;
		this.emailId = emailId;
		this.bookedTurfNo = bookedTurfNo;
		this.contactNo = contactNo;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBookedTurfNo() {
		return bookedTurfNo;
	}
	public void setBookedTurfNo(String bookedTurfNo) {
		this.bookedTurfNo = bookedTurfNo;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	

}
