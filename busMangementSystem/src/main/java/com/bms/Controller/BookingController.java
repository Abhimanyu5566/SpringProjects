package com.bms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.Entity.Booking;
import com.bms.Entity.RequestIds;
import com.bms.Service.BookingServices;

@RestController
public class BookingController {

	@Autowired
	BookingServices bookingServices;
	
	@PostMapping("/add/passenger")
	String addNewBooking (@RequestBody RequestIds re) {
		
		return bookingServices.addBookingnew(re);
	}
	
	@DeleteMapping("/delete/{bookingId}")
	void deletedByid(@PathVariable int bookingId) {
	
		bookingServices.deletingByBookingId(bookingId);
	}
}
