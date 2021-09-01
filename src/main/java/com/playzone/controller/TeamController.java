package com.playzone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Team;

import com.playzone.service.TeamService;

@CrossOrigin(origins="*")
@RequestMapping("/api/teams")
@RestController
public class TeamController {

	
	
	@Autowired
	private  TeamService teamService;
	
	@PostMapping
	public Team createTeam(@RequestBody Team team) {
		return teamService.createTeam(team);
		
		
	}
	
	@GetMapping
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	
	
	
	@GetMapping("/{teamId}")
	public ResponseEntity<Team> getByTeamId(@PathVariable int teamId) throws ResourceNotFoundException {
		Team team= teamService.getByTeamId(teamId);
		
		return ResponseEntity.ok().body(team);
	}
	
	@DeleteMapping("/{teamId}")
	public Map<String,Boolean> deleteTeamById(@PathVariable int teamId) throws ResourceNotFoundException{
		
		return teamService.deleteTeamById(teamId); 
		
	}
	
	
	@PutMapping("/{teamId}")
	public ResponseEntity<Team> updateTeamById(@PathVariable (value="teamId") int teamId ,  @RequestBody Team teamDetails) throws ResourceNotFoundException{
		return teamService.updateTeamById(teamId, teamDetails); 
		
		
	}
	
	
	
}
