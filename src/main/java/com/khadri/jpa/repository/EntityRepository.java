package com.khadri.jpa.repository;

import com.khadri.jpa.entity.FoodItems;
import com.khadri.jpa.entity.ParkingSpace;
import com.khadri.jpa.entity.Restaurant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityRepository {

	private EntityManager entityManager;

	public EntityRepository(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}

	public void insertFoodItemsAndRestarent(FoodItems foodItems, Restaurant restaurant,ParkingSpace space) {
		entityManager.getTransaction().begin();
		entityManager.persist(foodItems);
		entityManager.persist(restaurant);
		foodItems.setRestaurant(restaurant);
		entityManager.getTransaction().commit();

	}
}
