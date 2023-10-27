package com.bms.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	
	private int busNo;
	private String busName;
	private String fromDestination;
	private String toDestination;
	private int totalSeats;
	private int availableSeats;
	private float price;
	
	@JsonInclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
	List<Booking> bookings;

	
		

}
