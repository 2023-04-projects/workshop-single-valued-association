package com.khadri.jpa.repository;

import com.khadri.jpa.entity.Item;
import com.khadri.jpa.entity.Order;
import com.khadri.jpa.entity.Restaurent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class RestaurentRepository {

	private EntityManager entityManager;

	public RestaurentRepository(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}

	public void insertRestaurentItem(Restaurent restaurent, Item item) {

		entityManager.getTransaction().begin();

		entityManager.persist(item);
		restaurent.setItem(item);

		entityManager.persist(restaurent);

		entityManager.getTransaction().commit();
	}

	public void mapToExistItem(Restaurent restaurent, int itemId) {
		Item itemExist = entityManager.find(Item.class, itemId);

		entityManager.getTransaction().begin();

		restaurent.setItem(itemExist);
		entityManager.persist(restaurent);

		entityManager.getTransaction().commit();
	}

	public void insertRestaurentAndItemAndOrders(Restaurent restaurent, Item item, Order orders) {

		entityManager.getTransaction().begin();

		entityManager.persist(item);
		restaurent.setItem(item);

		entityManager.persist(orders);

		restaurent.setItem(item);
		orders.setRestaurent(restaurent);

		entityManager.persist(restaurent);

		entityManager.getTransaction().commit();
	}

}
