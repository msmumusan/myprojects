package com.crudDemo.RestAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudDemo.RestAPI.dao.TeamMembersRepository;
import com.crudDemo.RestAPI.dao.TeamRepository;
import com.crudDemo.RestAPI.dto.TeamMembersDTO;
import com.crudDemo.RestAPI.entity.Team;
import com.crudDemo.RestAPI.entity.TeamMember;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

	@Autowired
	private TeamMembersRepository teamMemberRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public List<TeamMember> getAllTeamMember() {
		return teamMemberRepository.findAll();
	}

	@Override
	public void deleteTeamMember(int id) {

	}

	@Override
	public void updateTeamMember(TeamMembersDTO teamMembersDTO) {

	}

	@Override
	public List<TeamMember> getAllByMonth(int month) {
		return teamMemberRepository.findByMonth(month);
	}

	// @Override
	// public void createTeamMember(TeamMember teamMember) {
	// teamMemberRepository.save(teamMember);
	//
	// }

	@Override
	public List<TeamMember> getAllByYear(int year) {
		return teamMemberRepository.findByYear(year);
	}

	@Override
	public List<TeamMember> getById(int id) {
		return teamMemberRepository.findById(id);
	}

	@Override
	public TeamMember createTeamMember(TeamMember teamMember) {
		Team team = teamRepository.findById(teamMember.getTeam().getTeamId()).orElse(null);
		System.out.println("Getting teamId:::::" + teamMember.getTeam().getTeamId());
		if (team == null) {
			team = new Team();
		}
		teamMember.setTeam(team);
		return teamMemberRepository.save(teamMember);

	}



	
	
	
	/*
	 * @Override public List<TeamMember> getByIndexNumberUp(int index) {
	 * 
	 * int indexNum = index - 1;
	 * 
	 * System.out.println("Getting index num:::::" + indexNum); List<TeamMember>
	 * teamMembersList = new ArrayList<>();
	 * 
	 * long count = teamMemberRepository.count();
	 * System.out.println("Total count from database::::" + count);
	 * 
	 * if (index > 1 && index <= count) { TeamMember userInputIndex =
	 * teamMemberRepository.findByIndexNum(index); TeamMember
	 * reduceUserInputIndex = teamMemberRepository.findByIndexNum(indexNum);
	 * 
	 * System.out.println("Before Swap" + userInputIndex);
	 * System.out.println("Before Swap" + reduceUserInputIndex);
	 * 
	 * teamMembersList.add(userInputIndex);
	 * teamMembersList.add(reduceUserInputIndex);
	 * 
	 * teamMemberRepository.saveAll(teamMembersList); } else {
	 * System.out.println("There is no data for Up Remove"); }
	 * 
	 * System.out.println("Getting Data for Up Remove ::::" + teamMembersList);
	 * return teamMembersList;
	 * 
	 * }
	 * 
	 * @Override public List<TeamMember> getByIndexNumberDown(int index) {
	 * List<TeamMember> teamMembersList = new ArrayList<>();
	 * 
	 * long count = teamMemberRepository.count();
	 * System.out.println("Total count from database::::" + count);
	 * 
	 * if (index < count && index >= 1) {
	 * 
	 * TeamMember userInputIndex = teamMemberRepository.findByIndexNum(index);
	 * TeamMember increaseUserInputIndex =
	 * teamMemberRepository.findByIndexNum(index + 1);
	 * 
	 * teamMembersList.add(increaseUserInputIndex);
	 * teamMembersList.add(userInputIndex);
	 * 
	 * teamMemberRepository.saveAll(teamMembersList);
	 * System.out.println("Getting Data for Down Remove :::" + teamMembersList);
	 * } else { System.out.println("There is no Data to Down Remove"); }
	 * 
	 * return teamMembersList; }
	 */

	// @Override
	// public List<TeamMember> getById(int id, Sort sort) {
	//
	// return teamMemberRepository.findById(id, orderByIdAsc());
	// }
	//
	// private Sort orderByIdAsc() {
	// return new Sort(Sort.Direction.ASC, "regiterDate");

}
