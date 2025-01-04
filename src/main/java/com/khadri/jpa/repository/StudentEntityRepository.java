package com.khadri.jpa.repository;

import com.khadri.jpa.entity.College;
import com.khadri.jpa.entity.Course;
import com.khadri.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class StudentEntityRepository {
	private EntityManager entityManager;

	public StudentEntityRepository(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}

	public void insertStudentAndCollege(Student student, College college) {

		entityManager.getTransaction().begin();

		entityManager.persist(college);
		student.setCollege(college);
		entityManager.persist(student);

		entityManager.getTransaction().commit();
	}

	public void insertStudentAndCollegeAndCourse(Student student, College college, Course course) {

		entityManager.getTransaction().begin();

		entityManager.persist(college);
		student.setCollege(college);

		entityManager.persist(course);
	
		//bi directional 
		student.setCourse(course); 
		course.setStudent(student); 
		
		entityManager.persist(student);

		entityManager.getTransaction().commit();
	}

	public void mapExistCollege(Student student, int clgNo) {

		College existCollege = entityManager.find(College.class, clgNo);

		entityManager.getTransaction().begin();
		student.setCollege(existCollege);
		entityManager.persist(student);

		entityManager.getTransaction().commit();
	}


}
