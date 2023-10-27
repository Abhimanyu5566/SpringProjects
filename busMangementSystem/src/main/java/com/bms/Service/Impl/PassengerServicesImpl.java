package com.bms.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.Service.PassengerServices;
import com.bms.Entity.Passenger;
import com.bms.Repository.PassengerRepository;

@Service
public class PassengerServicesImpl implements PassengerServices {
	
	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public Passenger addNewPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		
		return passengerRepository.save(passenger);
	}

	@Override
	public List<Passenger> listOfPassengers() {
		// TODO Auto-generated method stub
		return passengerRepository.findAll();
	}

	@Override
	public Passenger findByIdPassenger(int Id) {
		// TODO Auto-generated method stub
		Optional<Passenger> optional = passengerRepository.findById(Id);
		if (optional.isPresent()) {
			
			Passenger passenger = optional.get();
			
			return passenger;
			
		}
		return null;
	}

	@Override
	public Passenger updateByIdPassenger(int id, Passenger passenger) {
		// TODO Auto-generated method stub
		Optional<Passenger> optional = passengerRepository.findById(id);
		if (optional.isPresent()) {
			
			Passenger updatePassenger = optional.get();
			updatePassenger.setEmailid(passenger.getEmailid());
			updatePassenger.setLastname(passenger.getLastname());
			updatePassenger.setName(passenger.getName());
			updatePassenger.setAddress(passenger.getAddress());
			updatePassenger.setPhoneNo(passenger.getPhoneNo());
			
			return passengerRepository.save(updatePassenger);
		}
		return null;
	}

	@Override
	public String deletingPassenger(int id) {
		// TODO Auto-generated method stub
		Optional<Passenger> optional = passengerRepository.findById(id);
		if (optional.isPresent()) {
			
			Passenger passenger = optional.get();
			passengerRepository.deleteById(passenger.getPassengerId());
			return "Deleted passenger data  Successfully \n "+passenger;
					
			
		}
		return "Enter Passenger Id Not found in Database";
	}

}
