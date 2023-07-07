package com.citi.amenitiesbooking.model;

import java.sql.Date;

public class BookingInqRequest {
	private String location;
	private Date fromDate;
	private Date toDate;
	public BookingInqRequest() {
		super();
	}
	public BookingInqRequest(String location, Date fromDate, Date toDate) {
		super();
		this.location = location;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}



	
	
}
