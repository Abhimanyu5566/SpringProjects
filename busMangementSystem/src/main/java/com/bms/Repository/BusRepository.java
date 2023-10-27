package com.bms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.Entity.Bus;

public interface BusRepository  extends JpaRepository<Bus, Integer>{

}
