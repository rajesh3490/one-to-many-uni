package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestSaveMobile {

	public static void main(String[] args) {

		List<Sim> listSim = new ArrayList<Sim>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Sim sim1 = new Sim();
		sim1.setProvider("idea");
		sim1.setImrc(4321);
		listSim.add(sim1);

		Sim sim2 = new Sim();
		sim2.setProvider("airtel");
		sim2.setImrc(9012);
		listSim.add(sim2);

		Mobile mobile = new Mobile();
		mobile.setName("Nokia");
		mobile.setCost(10000);
		mobile.setSim(listSim);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();
		System.out.println("data stored");

	}

}
