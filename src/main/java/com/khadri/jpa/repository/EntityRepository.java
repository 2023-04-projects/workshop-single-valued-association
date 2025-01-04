package com.khadri.jpa.repository;

import com.khadri.jpa.entity.Biryani;
import com.khadri.jpa.entity.Customer;
import com.khadri.jpa.entity.CustomerOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityRepository {

	private EntityManager entityManager;

	public EntityRepository(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}
	public void insertCustomerAndOrder(Customer customer, CustomerOrder customerOrder) {

		entityManager.getTransaction().begin();

		entityManager.persist(customerOrder);
		customer.setCustomerOrder(customerOrder);
		entityManager.persist(customer);

		entityManager.getTransaction().commit();
	}

	public void insertCustomerAndOrderAndBiryani(Customer customer, CustomerOrder customerOrder,
			Biryani biryani) {

		entityManager.getTransaction().begin();

		entityManager.persist(customerOrder);
		customer.setCustomerOrder(customerOrder);

		entityManager.persist(biryani);
	
		
		customer.setBiryani(biryani);
		biryani.setCustomer(customer);
		
		entityManager.persist(customer);

		entityManager.getTransaction().commit();
	}

	public void mapExistCustomer(Customer customer, int custId) {

		CustomerOrder existCustomer = entityManager.find(CustomerOrder.class, custId);

		entityManager.getTransaction().begin();
		customer.setCustomerOrder(existCustomer);
		entityManager.persist(customer);

		entityManager.getTransaction().commit();
	}

}
