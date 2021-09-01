package com.playzone.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Team implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int teamId;
	
	
	private String teamName;
	
	
	private int userId;
	

	private String status;
	
	private String teamCode;
	
	
	private double regAmount;

	
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	  "team") private List<TeamMember> teamMember;
	 
}
