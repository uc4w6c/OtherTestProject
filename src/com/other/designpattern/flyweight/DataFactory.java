package com.other.designpattern.flyweight;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.other.hibernate.bean.Balance;

public class DataFactory {

	private HashMap<Integer, Balance> pool = new HashMap();

	private static DataFactory singleton = new DataFactory();

	private DataFactory() {}

	public static DataFactory getInstance() {
		return singleton;
	}

	public synchronized Balance getBalance(int id) {
		Balance balance = (Balance)pool.get(id);
		if (balance == null) {
			EntityManagerFactory factory = null;
			EntityManager manager = null;

			try {
				factory = Persistence.createEntityManagerFactory("app");
				manager = factory.createEntityManager();
				balance = manager
						.createQuery("select b from Balance b where b.id = :id", Balance.class)
						.setParameter("id", id)
						.getSingleResult();
				pool.put(id, balance);
			} catch (RuntimeException e) {
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
		return balance;
	}

}
