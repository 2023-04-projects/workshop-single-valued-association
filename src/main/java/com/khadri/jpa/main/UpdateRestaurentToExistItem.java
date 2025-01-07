package com.khadri.jpa.main;

import com.khadri.jpa.entity.Restaurent;
import com.khadri.jpa.repository.RestaurentRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateRestaurentToExistItem {

	private RestaurentRepository restaurentRepository;
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		restaurentRepository = new RestaurentRepository(entityManagerFactory);
	}

	public static void main(String[] args) {

		UpdateRestaurentToExistItem restaurentToExistItem = new UpdateRestaurentToExistItem();

		Restaurent restaurent = new Restaurent();
		restaurent.setName("MCDOWNALD'S");
		restaurent.setLocation("HYDERBAD");
		restaurentToExistItem.newEntryForRestaurentAndItem(restaurent, 1);
	}

	private void newEntryForRestaurentAndItem(Restaurent restaurent, int item) {
		restaurentRepository.mapToExistItem(restaurent, item);
	}
}
