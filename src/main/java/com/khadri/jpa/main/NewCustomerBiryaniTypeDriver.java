package com.khadri.jpa.main;

import com.khadri.jpa.entity.Customer;
import com.khadri.jpa.entity.CustomerOrder;
import com.khadri.jpa.repository.EntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewCustomerBiryaniTypeDriver {

	private EntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new EntityRepository(factory);
	}

	public static void main(String[] args) {
		NewCustomerBiryaniTypeDriver driver = new NewCustomerBiryaniTypeDriver();

		Customer customer = new Customer();
		customer.setName("priyanka");
		customer.setPhone_number(9581610639l);

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setName("biryani");
		customerOrder.setPrice(500.0);
		
		driver.newEntryForCustomerAndCustomerOrder(customer, customerOrder);
	}

	private void newEntryForCustomerAndCustomerOrder(Customer cust, CustomerOrder customerOrder) {
		repository.insertCustomerAndOrder(cust, customerOrder);
	}
}
