package com.bms.Service;

import java.util.List;

import javax.persistence.Id;

import com.bms.Entity.Bus;

public interface BusServices {
	
	Bus addnewBus(Bus bus);
	
	List<Bus> findAllBus();
	
	Bus findByBusIdNo(int id);
	
	Bus updateByBusId(int id, Bus bus);
	
	String deletingByBusId(int id);

}
