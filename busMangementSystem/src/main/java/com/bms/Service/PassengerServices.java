package com.bms.Service;

import java.util.List;

import com.bms.Entity.Passenger;

public interface PassengerServices {
	
	Passenger addNewPassenger(Passenger passenger);
	
	List<Passenger> listOfPassengers();
	
	Passenger findByIdPassenger(int Id);
	
	Passenger updateByIdPassenger(int id, Passenger passenger);
	
	String deletingPassenger(int id);

}
