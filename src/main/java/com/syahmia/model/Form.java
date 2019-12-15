package com.syahmia.model;

import org.hibernate.validator.constraints.NotEmpty;

/*
	We will use this class for binding from data to the model using @ModelAttribute annotation in controller's handler method.
*/

public class Form {

	@NotEmpty(message = "Enter name")
	private String name;

	@NotEmpty(message = "Enter age")
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
