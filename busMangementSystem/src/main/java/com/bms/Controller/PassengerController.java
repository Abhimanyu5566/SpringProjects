package com.bms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.Entity.Passenger;
import com.bms.Service.PassengerServices;


@RestController
@RequestMapping("/user")
public class PassengerController {
	
	@Autowired
	PassengerServices passengerServices;
	
	@PostMapping("/add")
	Passenger addNewPassenger(@RequestBody Passenger passenger) {
		
		return passengerServices.addNewPassenger(passenger);
		
	}
	
	@GetMapping("/passenger-list")
	List<Passenger> lisOfPassengers(){
		return passengerServices.listOfPassengers();
		
	}
	
	@GetMapping("/passenger-Id/{id}")
	Passenger findByIdPassenger(@PathVariable int id) {
		return passengerServices.findByIdPassenger(id);
		
	}
	
	@PutMapping("/update-passenger-by-id/{id}")
	Passenger updatePassengerList(@PathVariable int id, @RequestBody Passenger passenger ) {
		
		return passengerServices.updateByIdPassenger(id, passenger);
	}
	
	
	@DeleteMapping("/deleted-passenger-by-Id/{id}")
	String deletingPassengerById(int id) {
		
		return passengerServices.deletingPassenger(id);
	}

}
