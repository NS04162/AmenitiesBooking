package com.citi.amenitiesbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBookingInfo {
	private String bookingId;
	private String emailId;
	private String bookedTurfNo;
	private int contactNo;

}
