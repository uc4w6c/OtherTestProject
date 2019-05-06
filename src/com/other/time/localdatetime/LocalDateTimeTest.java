package com.other.time.localdatetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * dateTimeをテストしてみる
 * ミリ秒・ナノ秒まで出力したかったけど、Linuxの仕様側で難しい？timeサーバを使わなきゃいけないのかな？
 * @author ysaito
 *
 */
public class LocalDateTimeTest {

	public static void main(String[] args) {
		Date date = new Date();
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(localDateTime);
		System.out.println(localDateTime.getNano());

		LocalDateTime nowLocalDt = LocalDateTime.now();
		System.out.println(nowLocalDt);
		System.out.println(nowLocalDt.getNano());

		LocalDateTime instantDt = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println(instantDt);
		System.out.println(instantDt.getNano());
		System.out.println(ChronoUnit.MILLIS.between(localDateTime, nowLocalDt));
	}
}
