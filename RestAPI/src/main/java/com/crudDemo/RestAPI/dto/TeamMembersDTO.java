package com.crudDemo.RestAPI.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TeamMembersDTO {

	private int id;
	private String name;
	private String address;
	private String phone;
	private Date regiterDate;

}
