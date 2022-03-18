package com.crudDemo.RestAPI.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.crudDemo.RestAPI.dto.TeamMembersDTO;
import com.crudDemo.RestAPI.entity.TeamMember;


public interface TeamMemberService {
	TeamMember createTeamMember(TeamMember teamMember);

	List<TeamMember> getAllTeamMember();

	void deleteTeamMember(int id);

	void updateTeamMember(TeamMembersDTO teamMembersDTO);
	
	List<TeamMember> getAllByMonth(int month);
	
	List<TeamMember> getAllByYear(int year);
	
	List<TeamMember> getById(int id);
	
//	List<TeamMember> getByIndexNumberUp(int index);
//	
//	List<TeamMember> getByIndexNumberDown(int index);
}
