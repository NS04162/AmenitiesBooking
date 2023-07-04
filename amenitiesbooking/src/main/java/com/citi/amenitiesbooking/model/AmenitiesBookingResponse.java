package com.citi.amenitiesbooking.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmenitiesBookingResponse {
	private String bookingId;
	private String amenityTurfDetail;
	private boolean bookingFlag;
	private List<String> availableAmenities;

}
