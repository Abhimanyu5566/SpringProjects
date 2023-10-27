package com.bms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

}
