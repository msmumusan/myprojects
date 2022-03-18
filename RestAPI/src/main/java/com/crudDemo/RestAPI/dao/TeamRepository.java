package com.crudDemo.RestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudDemo.RestAPI.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findByIndexNum(int index);

}
