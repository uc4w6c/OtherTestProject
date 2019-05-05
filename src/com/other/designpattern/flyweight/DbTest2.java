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
 * FlyWeightを利用するパターン
 * @author ysaito
 *
 */
public class DbTest2 {
	public static void main(String[] args) {
		DataFactory dataFactory = DataFactory.getInstance();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Balance balance = dataFactory.getBalance(1);
			System.out.println("回数：" + i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("開始時刻：" + startTime + " ms");
		System.out.println("終了時刻：" + endTime + " ms");
		System.out.println("処理時間：" + (endTime - startTime) + " ms");

	}
}
