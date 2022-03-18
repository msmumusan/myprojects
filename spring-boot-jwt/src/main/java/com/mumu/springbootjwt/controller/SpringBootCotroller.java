package com.mumu.springbootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootCotroller {

	@GetMapping("/data")
	public String infoPage(){
		System.out.println("Get started....");
		return "HEllo world";
	}
}
