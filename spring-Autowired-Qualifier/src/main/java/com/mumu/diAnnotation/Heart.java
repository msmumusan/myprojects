package com.mumu.diAnnotation;

public class Heart {
	private String nameOfAnimal;
	private int noOfHeart;

	public String getNameOfAnimal() {
		return nameOfAnimal;
	}

	public void setNameOfAnimal(String noOfAnimal) {
		this.nameOfAnimal = noOfAnimal;
	}

	public int getNoOfHeart() {
		return noOfHeart;
	}

	public void setNoOfHeart(int noOfHeart) {
		this.noOfHeart = noOfHeart;
	}

	public void heartBeat() {
		System.out.println("You are breathing....");
	}
}
