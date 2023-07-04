package com.citi.amenitiesbooking.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmenitiesBookingRequest {
	private int amenitiesCode;
	private Date bookingDate;
	private String emailId;
	private int contactNo;

}
