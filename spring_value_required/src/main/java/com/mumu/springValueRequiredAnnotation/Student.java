package com.mumu.springValueRequiredAnnotation;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	@Value("${name}")
	private String name;
	@Value("${instrestCourse}")
	private String instrestCourse;
	//@Value("${hobby}")
	private String hobby;

	/*
	 * public void setName(String name) { this.name = name;
	 * System.out.println("Using setter method..."); }
	 * 
	 * public void setInstrestCourse(String instretCourse) { this.instrestCourse
	 * = instretCourse; }
	 * 
	 * public void setHobby(String hobby) { this.hobby = hobby; }
	 */

	public void displayInfo() {
		System.out.println("Name is " + name + " and instrest Course is " + instrestCourse + " and hobby is " + hobby);
	}
}
