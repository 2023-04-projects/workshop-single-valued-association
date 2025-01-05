package com.khadri.jpa.main;

import com.khadri.jpa.entity.Student;
import com.khadri.jpa.repository.StudentEntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateStudentToExistCollegeDriver {

	private StudentEntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new StudentEntityRepository(factory);
	}

	public static void main(String[] args) {
		UpdateStudentToExistCollegeDriver driver = new UpdateStudentToExistCollegeDriver();

		Student student = new Student();
		student.setName("KALAM");
		student.setFee(20000);

		driver.newEntryForStudentAndCollege(student, 1);
	}

	private void newEntryForStudentAndCollege(Student std, int clgNo) {
		repository.mapExistCollege(std, clgNo);
	}
}
