package com.bms.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import com.bms.Entity.Bus;
import com.bms.Repository.BusRepository;
import com.bms.Service.BusServices;

@Service
public class BusServicesImpl implements BusServices {

	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus addnewBus(Bus bus) {
		// TODO Auto-generated method stub
		bus.setAvailableSeats(bus.getTotalSeats());
		return busRepository.save(bus);
	}

	@Override
	public List<Bus> findAllBus() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}

	@Override
	public Bus findByBusIdNo(int id) {
		// TODO Auto-generated method stub
		Optional<Bus> optional = busRepository.findById(id);
		if (optional.isPresent()) {
			
			Bus bus =  optional.get();
			
			return bus;
		}
		
		return null;
		
	}

	@Override
	public Bus updateByBusId(int id, Bus bus) {
		// TODO Auto-generated method stub
		Optional<Bus> optional = busRepository.findById(id);
		if (optional.isPresent()) {
			
			Bus updateBus = optional.get();
			
			updateBus.setAvailableSeats(bus.getAvailableSeats());
			updateBus.setBusName(bus.getBusName());
			updateBus.setBusNo(bus.getBusNo());
			updateBus.setFromDestination(bus.getFromDestination());
			updateBus.setToDestination(bus.getToDestination());
			updateBus.setPrice(bus.getPrice());
			updateBus.setTotalSeats(bus.getTotalSeats());
			
			return busRepository.save(updateBus);
			
		}
		
		return null;
	}

	@Override
	public String deletingByBusId(int id) {
		// TODO Auto-generated method stub
		Optional<Bus> optional = busRepository.findById(id);
		if (optional.isPresent()) {
			
			Bus bus = optional.get();
			
			busRepository.deleteById(id);
			
			return "Bus data deleted Successfully "+bus;
			
		}
		return null;
	}


}
