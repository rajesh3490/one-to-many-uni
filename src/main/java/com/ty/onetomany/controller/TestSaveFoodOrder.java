package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.FoodOrder;
import com.ty.onetomany.dto.Item;

public class TestSaveFoodOrder {

	public static void main(String[] args) {

		List<Item> li = new ArrayList<Item>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item = new Item();
		item.setName("biryani");
		item.setQty(1);
		item.setCost(200);
		li.add(item);

		Item item1 = new Item();
		item1.setName("kabab");
		item1.setQty(1);
		item1.setCost(150);
		li.add(item1);

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setCustomerName("rajesh");
		foodOrder.setAddress("basavanagudi");
		foodOrder.setPhone(9550556990l);
		foodOrder.setItem(li);

		entityTransaction.begin();
		entityManager.persist(item);
		entityManager.persist(item1);
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		System.out.println("data is stored");

	}

}
