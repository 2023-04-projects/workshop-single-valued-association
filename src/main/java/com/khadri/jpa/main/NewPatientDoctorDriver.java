package com.khadri.jpa.main;

import com.khadri.jpa.entity.Doctor;
import com.khadri.jpa.entity.Patient;
import com.khadri.jpa.repository.EntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewPatientDoctorDriver {

	private EntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new EntityRepository(factory);
	}

	public static void main(String[] args) {
		NewPatientDoctorDriver driver = new NewPatientDoctorDriver();

		Patient patient = new Patient();
		patient.setPatientName("Deepika");
		patient.setPhoneNumber(9877565434L);

		Doctor doctor = new Doctor();
		doctor.setDoctorName("Dr.Reema");
		doctor.setSpecialty("Dermotologist");
		doctor.setPhoneNumber(9456634334L);

		driver.newEntryForPatientAndDoctor(patient, doctor);
	}

	private void newEntryForPatientAndDoctor(Patient patient, Doctor doctor) {
		repository.insertPatientAndDoctor(patient, doctor);
	}

}
