package com.khadri.jpa.main;

import com.khadri.jpa.entity.FoodItems;
import com.khadri.jpa.entity.Location;
import com.khadri.jpa.entity.ParkingSpace;
import com.khadri.jpa.entity.Restaurant;
import com.khadri.jpa.repository.EntityRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RestarentFoodItemDriver {
	private EntityRepository repository;
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new EntityRepository(factory);
	}

	public static void main(String[] args) {
		RestarentFoodItemDriver driver = new RestarentFoodItemDriver();

		FoodItems foodItems = new FoodItems();
		foodItems.setFoodItemName("BIRIYANI");
		foodItems.setFoodItemPrice(220.00);

		Restaurant restaurant = new Restaurant();

		restaurant.setName("MEFIL");
		ParkingSpace space = new ParkingSpace();
		space.setLot(200);
		space.setLocation(Location.EAST);
		driver.newEntryForFoodItemsForRestarent(foodItems, restaurant, space);

	}

	private void newEntryForFoodItemsForRestarent(FoodItems items, Restaurant restaurant1, ParkingSpace parkingSpace) {
		repository.insertFoodItemsAndRestarent(items, restaurant1, parkingSpace);
	}
}
