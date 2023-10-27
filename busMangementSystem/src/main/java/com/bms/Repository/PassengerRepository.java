package com.bms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
