package com.khadri.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer patientId;
	private String patientName;
	private Long phoneNumber;

	@ManyToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	@OneToOne
	@JoinColumn(name = "appointId")
	private Appointment appoint;

	public Appointment getAppoint() {
		return appoint;
	}

	public void setAppoint(Appointment appoint) {
		this.appoint = appoint;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", phoneNumber=" + phoneNumber
				+ ", doctor=" + doctor + ", appoint=" + appoint + "]";
	}

}
