package com.khadri.jpa.main;

import com.khadri.jpa.entity.College;
import com.khadri.jpa.entity.Student;
import com.khadri.jpa.repository.StudentEntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewStudentCollegeDriver {

	private StudentEntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new StudentEntityRepository(factory);
	}

	public static void main(String[] args) {
		NewStudentCollegeDriver driver= new NewStudentCollegeDriver();
		
	Student student = new Student();
	student.setName("ALLEN");
	student.setFee(50000);
		
		College college = new College();
		college.setName("govt arts clg");
		
		driver.newEntryForEmployeeAndDepartment(student,college);
	}

	private void newEntryForEmployeeAndDepartment(Student std, College college) {
		repository.insertStudentAndCollege(std, college);
	}
}
