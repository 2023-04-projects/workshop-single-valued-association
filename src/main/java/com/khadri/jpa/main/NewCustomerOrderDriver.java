package com.khadri.jpa.main;

import com.khadri.jpa.entity.Biryani;
import com.khadri.jpa.entity.Customer;
import com.khadri.jpa.entity.CustomerOrder;
import com.khadri.jpa.entity.Location;
import com.khadri.jpa.repository.EntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewCustomerOrderDriver {

	private EntityRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new EntityRepository(factory);
	}

	public static void main(String[] args) {
		NewCustomerOrderDriver driver= new NewCustomerOrderDriver();
		
		Customer customer = new Customer();
		customer.setName("Priyanka");
		customer.setPhone_number(9581610639l);
		
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setName("biryani");
		customerOrder.setPrice(500);
		
		Biryani biryani = new Biryani();
		biryani.setBiryani_type(1);
		biryani.setLocation(Location.PULIVENDULA);
		
		
		driver.newEntryForCustomerAndCustomerOrder(customer,customerOrder,biryani);
	}

	private void newEntryForCustomerAndCustomerOrder(Customer cust, CustomerOrder customerOrder,Biryani biryani) {
		repository.insertCustomerAndOrderAndBiryani(cust, customerOrder,biryani);
	}
}
