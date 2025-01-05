package com.khadri.jpa.main;

import com.khadri.jpa.entity.Patient;
import com.khadri.jpa.repository.EntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdatePatientToExistDoctorDriver {

	private EntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new EntityRepository(factory);
	}

	public static void main(String[] args) {
		UpdatePatientToExistDoctorDriver driver = new UpdatePatientToExistDoctorDriver();

		Patient patient = new Patient();
		patient.setPatientName("Rozy");
		patient.setPhoneNumber(9887566744L);

		driver.newEntryForPatientAndDoctor(patient, 1);

	}

	private void newEntryForPatientAndDoctor(Patient patient, int patientId) {
		repository.mapExistPatient(patient, patientId);
	}

}
