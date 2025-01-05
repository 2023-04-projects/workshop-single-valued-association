package com.khadri.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointId;
	private LocalDate appointDate;

	@Enumerated(EnumType.STRING)
	private Location location;

	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getAppointId() {
		return appointId;
	}

	public void setAppointId(Integer appointId) {
		this.appointId = appointId;
	}

	public LocalDate getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(LocalDate appointDate) {
		this.appointDate = appointDate;
	}

	@Override
	public String toString() {
		return "Appointment [appointId=" + appointId + ", appointDate=" + appointDate + ", location=" + location
				+ ", patient=" + patient + "]";
	}

}
