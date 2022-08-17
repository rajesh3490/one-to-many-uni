package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Bus;
import com.ty.onetomany.dto.Organisation;

public class TestSaveOrganisation {

	public static void main(String[] args) {

		List<Bus> lb = new ArrayList<Bus>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bus bus = new Bus();
		bus.setCapacity(44);
		bus.setType("sleepers");
		lb.add(bus);

		Bus bus1 = new Bus();
		bus1.setCapacity(55);
		bus1.setType("passanger");
		lb.add(bus1);

		Bus bus2 = new Bus();
		bus2.setCapacity(40);
		bus2.setType("express");
		lb.add(bus2);

		Organisation organisation = new Organisation();
		organisation.setName("KSRTC");
		organisation.setAddress("bangalore");
		organisation.setBus(lb);

		entityTransaction.begin();
		entityManager.persist(organisation);
		entityManager.persist(bus);
		entityManager.persist(bus1);
		entityManager.persist(bus2);
		entityTransaction.commit();

		System.out.println("data stored");
	}

}
