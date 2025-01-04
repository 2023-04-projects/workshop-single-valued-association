package com.khadri.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "biryani")
public class Biryani {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int biryani_type;
	@Enumerated(EnumType.STRING)
	private Location location;

	@OneToOne(mappedBy = "biryani")
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBiryani_type() {
		return biryani_type;
	}

	public void setBiryani_type(int biryani_type) {
		this.biryani_type = biryani_type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

}
