package com.khadri.jpa.main;


import com.khadri.jpa.entity.Item;
import com.khadri.jpa.entity.Order;
import com.khadri.jpa.entity.OrderStatus;
import com.khadri.jpa.entity.Restaurent;
import com.khadri.jpa.repository.RestaurentRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewRestuarentItemOrdersDriver {
	
	private RestaurentRepository repository;

	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		repository = new RestaurentRepository(factory);
	}

	public static void main(String[] args) {
		NewRestuarentItemOrdersDriver itemOrdersDriver = new NewRestuarentItemOrdersDriver();
		
		Restaurent restaurent = new Restaurent();
		restaurent.setName("RUHRESTAURENT");
		restaurent.setLocation("BANGLURU");
		
		Item item = new Item();
		item.setName("LOLLYPOP");
		item.setPrice(550);
		
		Order order = new Order();
		order.setOrderNum(234);
		order.setStatus(OrderStatus.DELIVERED);
		
		itemOrdersDriver.newEntryForRestaurentAndItem(restaurent, item, order);
	}

	private void newEntryForRestaurentAndItem(Restaurent res, Item item, Order  ord) {
		repository.insertRestaurentAndItemAndOrders(res, item, ord);
	}
}
