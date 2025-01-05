package com.khadri.jpa.entity;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class FoodItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fooditem_id")
	private int foodItemId;
	@Column(name = "fooditem_name")
	private String foodItemName;
	@Column(name = "fooditem_price")
	private double foodItemPrice;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@OneToOne
	private ParkingSpace parkingSpace;

	public int getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public double getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

}
