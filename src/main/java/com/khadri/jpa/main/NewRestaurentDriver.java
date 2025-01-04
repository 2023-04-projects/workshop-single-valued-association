package com.khadri.jpa.main;

import com.khadri.jpa.entity.Item;
import com.khadri.jpa.entity.Restaurent;
import com.khadri.jpa.repository.RestaurentRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewRestaurentDriver {

	private RestaurentRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new RestaurentRepository(factory);
	}
	
	public static void main(String[] args) {
		NewRestaurentDriver restaurentDriver =  new NewRestaurentDriver();
		
		Restaurent restaurent = new  Restaurent();
		restaurent.setName("NANDAGOKUL");
		restaurent.setLocation("BANGLURU");
		
		Item item = new Item();
			item.setName("DOSA");
			item.setPrice(100);
			
			restaurentDriver.newEntryForRestaurentAndItem(restaurent, item);
	}
	
	private void newEntryForRestaurentAndItem(Restaurent restur, Item item) {
		repository.insertRestaurentItem(restur, item);

	}
}
