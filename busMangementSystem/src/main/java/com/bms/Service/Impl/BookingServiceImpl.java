package com.bms.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.Entity.Booking;
import com.bms.Entity.Bus;
import com.bms.Entity.Passenger;
import com.bms.Entity.RequestIds;
import com.bms.Repository.BookingRepository;
import com.bms.Repository.BusRepository;
import com.bms.Repository.PassengerRepository;
import com.bms.Service.BookingServices;

@Service
public class BookingServiceImpl implements BookingServices {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@Override
	public String addBookingnew(RequestIds requestIds) {
		// TODO Auto-generated method stub
		
		Optional<Passenger> optional = passengerRepository.findById(requestIds.getPassengerId());
		if (optional.isPresent()) {
			
			Passenger passenger = optional.get();
			
			Optional<Bus> optional2 = busRepository.findById(requestIds.getBusId());
			if (optional2.isPresent()) {
				
				Bus bus = optional2.get();
				
				Booking booking = new Booking();
				booking.setBus(bus);
				booking.setPassenger(passenger);
				booking.setAmount(bus.getPrice());
				
				bus.setAvailableSeats(bus.getAvailableSeats()- 1);
				
				busRepository.save(bus);
				
				bookingRepository.save(booking);
				
				return "Add booking passengers";
				
			}else {
				
				return "Bus Id Not found in database";
				
			}
			
			
		}
		
		
		return "Passenger Id Not found in database";	
	}

	
	
	@Override
	public void deletingByBookingId(int id) {
		// TODO Auto-generated method stub
		
		Optional<Booking> optional = bookingRepository.findById(id);
		if (optional.isPresent()) {
			
			Booking booking = optional.get();
			
			Bus bus = busRepository.findById(booking.getBookingIds()).get();
			bus.setAvailableSeats(bus.getAvailableSeats()+1);
			
			busRepository.save(bus);
			 
			bookingRepository.deleteById(id);
			
		}
	}
	

	
}
