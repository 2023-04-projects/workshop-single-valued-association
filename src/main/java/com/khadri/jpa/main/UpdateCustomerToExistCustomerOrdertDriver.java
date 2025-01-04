package com.khadri.jpa.main;

import com.khadri.jpa.entity.Customer;
import com.khadri.jpa.repository.EntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateCustomerToExistCustomerOrdertDriver {

	private EntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new EntityRepository(factory);
	}

	public static void main(String[] args) {
		UpdateCustomerToExistCustomerOrdertDriver driver = new UpdateCustomerToExistCustomerOrdertDriver ();

		Customer customer = new Customer();
		customer.setName("priyanka");
		customer.setPhone_number(9581610639l);

		driver.newEntryForCustomerAndCustomerOrder(customer,1);
	}

	private void newEntryForCustomerAndCustomerOrder(Customer cust,int custId) {
		repository.mapExistCustomer(cust,custId);
	}
}
