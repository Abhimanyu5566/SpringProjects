package com.bms.Entity;






import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingIds;
	
	private float amount;

	@CreationTimestamp
	private Date date;
	
	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "busId")
	Bus bus;
	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "passengerId")
	Passenger passenger;
	
	
	
	
	
	
	
}
