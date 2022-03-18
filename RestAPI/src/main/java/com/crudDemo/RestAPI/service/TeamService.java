package com.crudDemo.RestAPI.service;

import java.util.List;

import com.crudDemo.RestAPI.entity.Team;

public interface TeamService {
	
	void createTeam(Team team);

	List<Team> getByIndexNumberUp(int index);
	
	List<Team> getByIndexNumberDown(int index);
	


	
}
