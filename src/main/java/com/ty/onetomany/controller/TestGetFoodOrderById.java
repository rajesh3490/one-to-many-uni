package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.FoodOrder;
import com.ty.onetomany.dto.Item;

public class TestGetFoodOrderById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		FoodOrder foodOrder = entityManager.find(FoodOrder.class, 1);

		List<Item> listitem = foodOrder.getItem();

		System.out.println("foodOrder id is " + foodOrder.getId());
		System.out.println("foodOrder address is " + foodOrder.getAddress());
		System.out.println("foodOrder phone is " + foodOrder.getPhone());
		System.out.println("foodOrder customer name is " + foodOrder.getCustomerName());

		if (listitem != null) {
			for (Item item : listitem) {
				System.out.println("item id is " + item.getId());
				System.out.println("item name is " + item.getName());
				System.out.println("item qty is " + item.getQty());
				System.out.println("item cost is " + item.getCost());
			}
		}

	}

}
