package com.other.json.gson.service;

import com.google.gson.Gson;
import com.other.json.gson.bean.Person;

public class GsonTest {

	// gsonのテストクラス
	public static void main(String[] args) {
		String json = "{\"firstName\":\"太郎\",\"lastName\":\"田中\"}";
		Gson gson = new Gson();
		Person person = gson.fromJson(json, Person.class);
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
	}
}
