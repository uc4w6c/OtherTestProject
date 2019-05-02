package com.json.jackson.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.jackson.bean.Person;

public class JacksonTest {

	// jacksonのテストクラス
	public static void main(String[] args) {
		String json = "{\"FirstName\":\"太郎\",\"LastName\":\"田中\"}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Person person = mapper.readValue(json, Person.class);
			System.out.println(person.getFirstName());
			System.out.println(person.getLastName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
