package com.citi.amenitiesbooking.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AmenitiesInfo {
	
	private int amenitiesCode;
	private String amenitiesName;
	private Date bookingDate;
	private int totalCount;
	private int currentAvailableCount;
	
	
	public AmenitiesInfo() {
		super();
	}
	
	public AmenitiesInfo(int amenitiesCode, String amenitiesName, Date bookingDate, int totalCount,
			int currentAvailableCount) {
		super();
		this.amenitiesCode = amenitiesCode;
		this.amenitiesName = amenitiesName;
		this.bookingDate = bookingDate;
		this.totalCount = totalCount;
		this.currentAvailableCount = currentAvailableCount;
	}
	
	public int getAmenitiesCode() {
		return amenitiesCode;
	}
	public void setAmenitiesCode(int amenitiesCode) {
		this.amenitiesCode = amenitiesCode;
	}
	public String getAmenitiesName() {
		return amenitiesName;
	}
	public void setAmenitiesName(String amenitiesName) {
		this.amenitiesName = amenitiesName;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentAvailableCount() {
		return currentAvailableCount;
	}
	public void setCurrentAvailableCount(int currentAvailableCount) {
		this.currentAvailableCount = currentAvailableCount;
	}
	
	
	

}
