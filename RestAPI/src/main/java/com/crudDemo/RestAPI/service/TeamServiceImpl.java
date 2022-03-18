package com.crudDemo.RestAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudDemo.RestAPI.dao.TeamRepository;
import com.crudDemo.RestAPI.entity.Team;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teampRepository;

	@Override
	public void createTeam(Team team) {
		teampRepository.save(team);
		System.out.println("Save to db::::" + team);
	}

	@Override
	public List<Team> getByIndexNumberUp(int index) {

		int indexNum = index - 1;

		System.out.println("Getting index num:::::" + indexNum);
		List<Team> teamList = new ArrayList<>();

		long count = teampRepository.count();
		System.out.println("Total count from database::::" + count);

		if (index > 1 && index <= count) {
			Team userInputIndex = teampRepository.findByIndexNum(index);
			Team reduceUserInputIndex = teampRepository.findByIndexNum(indexNum);

			System.out.println("Before Swap" + userInputIndex);
			System.out.println("Before Swap" + reduceUserInputIndex);

			teamList.add(userInputIndex);
			teamList.add(reduceUserInputIndex);

			teampRepository.saveAll(teamList);
		} else {
			System.out.println("There is no data for Up Remove");
		}
		System.out.println("Getting Data for Up Remove ::::" + teamList);
		return teamList;

	}

	@Override
	public List<Team> getByIndexNumberDown(int index) {
		List<Team> teamList = new ArrayList<>();

		long count = teampRepository.count();
		System.out.println("Total count from database::::" + count);

		if (index < count && index >= 1) {

			Team userInputIndex = teampRepository.findByIndexNum(index);
			Team increaseUserInputIndex = teampRepository.findByIndexNum(index + 1);

			teamList.add(increaseUserInputIndex);
			teamList.add(userInputIndex);

			teampRepository.saveAll(teamList);
			System.out.println("Getting Data for Down Remove :::" + teamList);
		} else {
			System.out.println("There is no Data to Down Remove");
		}

		return teamList;
	}

}
