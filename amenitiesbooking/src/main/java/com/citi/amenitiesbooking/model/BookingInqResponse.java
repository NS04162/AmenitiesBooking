package com.citi.amenitiesbooking.model;

import java.sql.Date;

public class BookingInqResponse {
	private Date bookingDate;
	private String aminitesName;
	private String turfDetails;
	private String userDetails;
	private Long count;
	public BookingInqResponse() {
		super();
	}
	public BookingInqResponse(Date bookingDate, String aminitesName, String turfDetails, String userDetails,
			Long count) {
		super();
		this.bookingDate = bookingDate;
		this.aminitesName = aminitesName;
		this.turfDetails = turfDetails;
		this.userDetails = userDetails;
		this.count = count;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getAminitesName() {
		return aminitesName;
	}
	public void setAminitesName(String aminitesName) {
		this.aminitesName = aminitesName;
	}
	public String getTurfDetails() {
		return turfDetails;
	}
	public void setTurfDetails(String turfDetails) {
		this.turfDetails = turfDetails;
	}
	public String getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BookingInqResponse [bookingDate=" + bookingDate + ", aminitesName=" + aminitesName + ", turfDetails="
				+ turfDetails + ", userDetails=" + userDetails + ", count=" + count + "]";
	}
	
	
	
}
