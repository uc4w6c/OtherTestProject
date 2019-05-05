package com.other.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.other.hibernate.bean.Balance;

public class HibernateTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("app");
			manager = factory.createEntityManager();

			/*
			Balance balance = manager.find(Balance.class, 1);
			System.out.println(balance);
			*/

			// これで成功した
			Query query = manager.createQuery("from Balance", Balance.class);
			List<Balance> balances = query.getResultList();
			System.out.println("balance SIZE::" + balances.size());
			for (Balance balance : balances) {
				System.out.println(balance);
			}

			transaction = manager.getTransaction();

			transaction.begin();
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}
}
