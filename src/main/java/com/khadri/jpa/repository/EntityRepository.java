package com.khadri.jpa.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;

public class EntityRepository {

	private EntityManager entityManager;

	public EntityRepository(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}

}
