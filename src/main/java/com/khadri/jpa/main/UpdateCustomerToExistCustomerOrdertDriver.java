package com.khadri.jpa.main;

import com.khadri.jpa.entity.Customer;
import com.khadri.jpa.repository.CustomerEntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateCustomerToExistCustomerOrdertDriver {

	private CustomerEntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new CustomerEntityRepository(factory);
	}

	public static void main(String[] args) {
		UpdateCustomerToExistCustomerOrdertDriver driver = new UpdateCustomerToExistCustomerOrdertDriver ();

		Customer customer = new Customer();
		customer.setName("Manvitha");
		customer.setPhone_number(94401610639l);

		driver.newEntryForCustomerAndCustomerOrder(customer,1);
	}

	private void newEntryForCustomerAndCustomerOrder(Customer cust,int custId) {
		repository.mapExistCustomer(cust,custId);
	}
}
