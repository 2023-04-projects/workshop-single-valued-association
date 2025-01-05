package com.khadri.jpa.repository;

import com.khadri.jpa.entity.Appointment;
import com.khadri.jpa.entity.Doctor;
import com.khadri.jpa.entity.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DoctorRepository {

	private EntityManager entityManager;

	public DoctorRepository(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}

	public void insertPatientAndDoctor(Patient patient, Doctor doctor) {

		entityManager.getTransaction().begin();
		entityManager.persist(doctor);
		patient.setDoctor(doctor);
		entityManager.persist(patient);

		entityManager.getTransaction().commit();

	}

	public void insertpatientAndDoctorAndAppointment(Patient patient, Doctor doctor, Appointment appoint) {

		entityManager.getTransaction().begin();
		entityManager.persist(doctor);
		patient.setDoctor(doctor);

		entityManager.persist(appoint);
		patient.setAppoint(appoint);

		appoint.setPatient(patient);
		entityManager.persist(patient);

		entityManager.getTransaction().commit();
	}

	public void mapExistPatient(Patient patient, int patientId) {
		Doctor existPatient = entityManager.find(Doctor.class, patientId);

		entityManager.getTransaction().begin();
		patient.setDoctor(existPatient);
		entityManager.persist(patient);

		entityManager.getTransaction().commit();

	}

}
