package com.khadri.jpa.main;

import com.khadri.jpa.entity.College;
import com.khadri.jpa.entity.Course;
import com.khadri.jpa.entity.Student;
import com.khadri.jpa.repository.StudentEntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewStudentCollegeCourseDriver {

	private StudentEntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new StudentEntityRepository(factory);
	}

	public static void main(String[] args) {
		NewStudentCollegeCourseDriver driver = new NewStudentCollegeCourseDriver();

		Student student = new Student();
		student.setName("ALLEN");
		student.setFee(50000);

		College college = new College();
		college.setName("govt arts clg");

		Course course = new Course();
		course.setCourseName("Bsc");

		driver.newEntryForStudentAndCollege(student, college, course);
	}

	private void newEntryForStudentAndCollege(Student std, College college, Course course) {
		repository.insertStudentAndCollegeAndCourse(std, college, course);
	}
}
