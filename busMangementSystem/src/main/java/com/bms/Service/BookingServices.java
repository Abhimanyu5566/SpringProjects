package com.bms.Service;

import com.bms.Entity.Booking;

import com.bms.Entity.RequestIds;

public interface BookingServices {

	
	String addBookingnew(RequestIds requestIds);
	
	void deletingByBookingId(int id);
	
	
	
}
