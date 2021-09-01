package com.playzone.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Team;



import com.playzone.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

	
	@Autowired
	TeamRepository teamRepository;
	
	
	
	@Override
	public List<Team> getAllTeams() {
		
		return teamRepository.findAll();
	}


	@Override
	public Team getByTeamId(int teamId) throws ResourceNotFoundException{
		Team team=teamRepository.findById(teamId).orElseThrow(()->new ResourceNotFoundException("Team not found for this id" +"  "+teamId));
		return team;
	}






	@Override
	public Team createTeam(Team team) {
		
		return teamRepository.save(team);
	}


	

	

	@Override
	public Map<String, Boolean> deleteTeamById(int teamId) throws ResourceNotFoundException{
		
		Team team =teamRepository.findById(teamId).orElseThrow(()->new ResourceNotFoundException("Team  not found for this id" +"  "+teamId));
		
		teamRepository.delete(team);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return  response;
	}




	
	@Override
	public ResponseEntity<Team> updateTeamById(@PathVariable (value="teamId") int teamId ,  @RequestBody Team teamDetails) throws ResourceNotFoundException{
		
	Team team =teamRepository.findById(teamId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+teamId));
	
	team.setTeamName(teamDetails.getTeamName());
	team.setUserId(teamDetails.getUserId());
	team.setStatus(teamDetails.getStatus());
	team.setTeamCode(teamDetails.getTeamCode());
	team.setTeamName(teamDetails.getTeamName());
	team.setRegAmount(teamDetails.getRegAmount());
	
	final Team updatedTeam=teamRepository.save(team);
	
	
	return ResponseEntity.ok(updatedTeam) ;
	}





	


}
