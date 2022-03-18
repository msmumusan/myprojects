package com.mumu.diAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {
	public Human() {

	}

	private Heart heart;

	
	public Human(Heart heart) {
		this.heart = heart;
	}

	@Autowired
	@Qualifier("catHeart")
	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("called setter method....");
	}

	public void startHeartBeating() {
		if (heart != null) {
			heart.heartBeat();
			System.out.println("Name of animal is : " + heart.getNameOfAnimal() + " and number of heart is : " + heart.getNoOfHeart());
		} else {
			System.out.println("Your heart is not beating.So you are Dead....");
		}
	}
}
