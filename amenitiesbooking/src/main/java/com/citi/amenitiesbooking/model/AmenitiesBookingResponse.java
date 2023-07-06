package com.citi.amenitiesbooking.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AmenitiesBookingResponse {
	private String bookingId;
	private String amenityTurfDetail;
	private boolean bookingFlag;
	private List<Map<String, Integer>> availableAmenities;
	
	public AmenitiesBookingResponse() {
		super();
	}


	public AmenitiesBookingResponse(String bookingId, String amenityTurfDetail, boolean bookingFlag,
			List<Map<String, Integer>> availableAmenities) {
		super();
		this.bookingId = bookingId;
		this.amenityTurfDetail = amenityTurfDetail;
		this.bookingFlag = bookingFlag;
		this.availableAmenities = availableAmenities;
	}


	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getAmenityTurfDetail() {
		return amenityTurfDetail;
	}

	public void setAmenityTurfDetail(String amenityTurfDetail) {
		this.amenityTurfDetail = amenityTurfDetail;
	}

	public boolean isBookingFlag() {
		return bookingFlag;
	}

	public void setBookingFlag(boolean bookingFlag) {
		this.bookingFlag = bookingFlag;
	}


	public List<Map<String, Integer>> getAvailableAmenities() {
		return availableAmenities;
	}


	public void setAvailableAmenities(List<Map<String, Integer>> availableAmenities) {
		this.availableAmenities = availableAmenities;
	}

	
	

}
