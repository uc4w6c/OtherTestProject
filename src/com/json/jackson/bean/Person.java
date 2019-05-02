package com.json.jackson.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private String firstName;
	private String lastName;

	public Person(@JsonProperty("FirstName") String firstName, 
				  @JsonProperty("LastName")String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
