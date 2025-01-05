package com.khadri.jpa.main;

import java.time.LocalDate;

import com.khadri.jpa.entity.Appointment;
import com.khadri.jpa.entity.Doctor;
import com.khadri.jpa.entity.Patient;
import com.khadri.jpa.repository.DoctorRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewAppointPatientDoctorDriver {

	private DoctorRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new DoctorRepository(factory);
	}

	public static void main(String[] args) {
		NewAppointPatientDoctorDriver driver = new NewAppointPatientDoctorDriver();

		Patient patient = new Patient();
		patient.setPatientName("Leena");
		patient.setPhoneNumber(9877565434L);

		Doctor doctor = new Doctor();
		doctor.setDoctorName("Dr.Neil");
		doctor.setSpecialty("Cardiologist");
		doctor.setPhoneNumber(98734347325L);

		Appointment appoint = new Appointment();
		LocalDate date = LocalDate.of(2025, 1, 4);
		appoint.setAppointDate(date);

		driver.newEntryForPatientAndDoctor(patient, doctor, appoint);
	}

	private void newEntryForPatientAndDoctor(Patient patient, Doctor doctor, Appointment appoint) {
		repository.insertpatientAndDoctorAndAppointment(patient, doctor, appoint);

	}
}
