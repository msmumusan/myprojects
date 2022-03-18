package com.crudDemo.RestAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudDemo.RestAPI.entity.Team;
import com.crudDemo.RestAPI.entity.TeamMember;
import com.crudDemo.RestAPI.service.TeamMemberService;
import com.crudDemo.RestAPI.service.TeamService;

@RestController
@RequestMapping(value = "/teamMembers")
public class TeamMembersApiController {

	@Autowired
	private TeamMemberService teamMemberSerivce;
	
//	@Autowired
//	private TeamService teamService;

	
	@PostMapping("/createTeamMember")
	public void createTeamMember(@RequestBody TeamMember teamMember){
		teamMemberSerivce.createTeamMember(teamMember);
	}
	
	/* @PostMapping("/saveTeamMembert/{teamName}")
	    public String saveTeamMember(@RequestBody List<TeamMember> teamMemberList, @PathVariable String teamName){
	        try {
	            Team team = teamService.findByTeamName(teamName);

	            for(TeamMember teamMember: teamMemberList)
	            	teamMember.setTeam(team);

	            
	            return "TeamMember saved successfully..";
	        }catch (Exception ex){
	            ex.printStackTrace();
	            return "Error in saving Student ..";
	        }
	 }*/
	
	@GetMapping("/{id}")
	public List<TeamMember> getTeamMember(@PathVariable int id, TeamMember teamMember){
		return teamMemberSerivce.getById(id);
	}
	
	@GetMapping("/getAllByMonth/{month}")
	public List<TeamMember> getAllByMonth(@PathVariable int month){
		return teamMemberSerivce.getAllByMonth(month);
	}
	
	@GetMapping("/getAllByYear/{year}")
	public List<TeamMember> getAllByYear(@PathVariable int year, TeamMember teamMember){
		return teamMemberSerivce.getAllByYear(year);
	}
	
	/*@GetMapping("/getByIndexNumberUp/{index}")
	public List<TeamMember> getByIndexNumberUp(@PathVariable int index){
		return teamMemberSerivce.getByIndexNumberUp(index);
		
	}
	
	
	@GetMapping("/getByIndexNumberDown/{index}")
	public List<TeamMember> getByIndexNumberDown(@PathVariable int index){
		return teamMemberSerivce.getByIndexNumberDown(index);
		
	}*/
	
	
	
}
