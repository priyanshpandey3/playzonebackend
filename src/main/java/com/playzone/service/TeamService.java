package com.playzone.service;

import java.util.List;
import java.util.Map;



import org.springframework.http.ResponseEntity;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Team;


public interface TeamService {

	public List<Team> getAllTeams();
	
	public Team getByTeamId(int teamId) throws ResourceNotFoundException;

	public Team createTeam(Team team);
	
	public Map<String, Boolean> deleteTeamById(int teamId) throws ResourceNotFoundException;
	public ResponseEntity<Team> updateTeamById(int teamId, Team teamDetails) throws ResourceNotFoundException;





}
