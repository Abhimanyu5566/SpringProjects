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

import com.bms.Entity.Bus;
import com.bms.Service.BusServices;

@RestController
@RequestMapping("/admin")
public class BusController {

	@Autowired
	BusServices busServices;
	
	@PostMapping("/add")
	Bus addnewBus(@RequestBody Bus bus) {
		
		return busServices.addnewBus(bus);
	}
	
	@GetMapping("/list-bus")
	List<Bus> findByList(){
		return busServices.findAllBus();
	}
	
	@GetMapping("/bus-id/{id}")
	Bus findByListBus(@PathVariable int id) {
		
		return busServices.findByBusIdNo(id);
	}
	
	@PutMapping("/bus-id/update-bus/{id}")
	Bus updateByIdBus(@PathVariable int id, @RequestBody Bus bus) {
		
		return busServices.updateByBusId(id, bus);
	}
	
	@DeleteMapping("/bus-delete/{id}")
	String deletingById(@PathVariable int id) {
		
		return busServices.deletingByBusId(id);
	}
}
