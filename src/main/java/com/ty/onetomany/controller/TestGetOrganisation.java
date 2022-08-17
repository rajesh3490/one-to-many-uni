package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Bus;
import com.ty.onetomany.dto.Organisation;

public class TestGetOrganisation {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Organisation organisation = entityManager.find(Organisation.class, 1);

		List<Bus> lb = organisation.getBus();

		System.out.println("organisation id is " + organisation.getId());
		System.out.println("organisation name is " + organisation.getName());
		System.out.println("organisation address is " + organisation.getAddress());

		if (lb != null) {
			for (Bus bus : lb) {
				System.out.println("organisation's bus id is " + bus.getId());
				System.out.println("organisation's bus capacity is " + bus.getCapacity());
				System.out.println("organisation's bus type is " + bus.getType());
			}

		}

	}

}
