package com.crudDemo.RestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudDemo.RestAPI.dao.TeamRepository;
import com.crudDemo.RestAPI.entity.Team;
import com.crudDemo.RestAPI.entity.TeamMember;
import com.crudDemo.RestAPI.service.TeamService;

@RestController
@RequestMapping(value = "/team")
public class TeamApiController {

	@Autowired
	private TeamService teamService;

	@Autowired
	private TeamRepository teamRepository;

	@PostMapping("/createTeam")
	public void createTeam(@RequestBody Team team) {
		teamService.createTeam(team);
	}

	/*// save Child with Parent at same
	@PostMapping(value = "/createTeam")
	public String OneToMany(@RequestBody Team team) {

		for (TeamMember teamMember : team.getTeamMemberList()) {
			teamMember.setTeam(team);
		}

		team.setTeamMemberList(team.getTeamMemberList());
		teamService.createTeam(team);
		System.out.println("TEAM: " + team);
		return "saved";

		
		 * { "name":"Romil", "child":[ {"account":"1"}, {"account":"2"} ] }
		 
	}*/

	@GetMapping("/getByIndexNumberUp/{index}")
	public List<Team> getByIndexNumberUp(@PathVariable int index) {
		return teamService.getByIndexNumberUp(index);

	}

	@GetMapping("/getByIndexNumberDown/{index}")
	public List<Team> getByIndexNumberDown(@PathVariable int index) {
		return teamService.getByIndexNumberDown(index);

	}

	@GetMapping("/descByIndexNum")
	public List<Team> getByDesc(@RequestParam String field, @RequestParam int page, @RequestParam int size) {
		PageRequest pageable = PageRequest.of(page, size, Direction.DESC, field);
		return teamRepository.findAll(pageable).toList();
	}

	@GetMapping("/ascByIndexNum")
	public List<Team> getByAsc(@RequestParam String field, @RequestParam int page, @RequestParam int size) {
		PageRequest pageable = PageRequest.of(page, size, Direction.ASC, field);
		return teamRepository.findAll(pageable).toList();
	}
}
