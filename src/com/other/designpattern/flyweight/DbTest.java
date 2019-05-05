package com.other.designpattern.flyweight;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.other.hibernate.bean.Balance;

/**
 * 通常通り毎回SQLを実行するパターン
 * @author ysaito
 *
 */
public class DbTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("app");
			manager = factory.createEntityManager();

			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				/*
				 * findだとキャッシュされちゃう
					Balance balance = manager.find(Balance.class, 1);
				*/
				Balance balance = manager
									.createQuery("select b from Balance b where b.id = :id", Balance.class)
									.setParameter("id", 1)
									.getSingleResult();
				System.out.println("回数：" + i);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("開始時刻：" + startTime + " ms");
			System.out.println("終了時刻：" + endTime + " ms");
			System.out.println("処理時間：" + (endTime - startTime) + " ms");

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
