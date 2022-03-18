package com.crudDemo.RestAPI.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "teamInfo")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler",
// "teamMemberList" })
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teamId;

	private String teamName;

	@Column(name = "index_num", unique = true)
	private int indexNum;

	@CreationTimestamp
	@Column(updatable = false)
	private java.sql.Timestamp createTime;

	@UpdateTimestamp
	@Column
	private java.sql.Timestamp updateTime;

	@JsonManagedReference
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
	@JsonIgnore
	private List<TeamMember> teamMemberList;

	/*public void addTeamMember(TeamMember teamMember) {
		this.teamMemberList.add(teamMember);
		teamMember.setTeam(this);

	}*/

}
