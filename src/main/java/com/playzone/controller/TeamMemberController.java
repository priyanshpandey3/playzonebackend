
package com.playzone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable; 
import com.playzone.exception.ResourceNotFoundException;

import com.playzone.model.TeamMember;
import com.playzone.service.TeamMemberService;

@CrossOrigin(origins="*")
@RequestMapping("/api/tms")

@RestController 
public class TeamMemberController {




	@Autowired 
	private TeamMemberService teamMemberService;


	@PostMapping
	public TeamMember addTeamMember(@RequestBody TeamMember teamMember) {

		return teamMemberService.addTeamMember(teamMember);

	}

	@GetMapping("/{teamId}")
	public List<TeamMember> getAllTeamMembersByTeamId( @PathVariable int teamId){
		return teamMemberService.getAllTeamMembers(teamId); 
	}

	@GetMapping
	public List<TeamMember> getAllTeamMembers(){
	return teamMemberService.getAllTeamMembers();
	}
	
	
	
	@DeleteMapping("/{memberId}")
	public Map<String,Boolean> deleteTeamMemberById(@PathVariable int memberId) throws ResourceNotFoundException{
		
		return teamMemberService.deleteTeamMemberById(memberId); 
		
	}
	
	
	@PutMapping("/{memberId}")
	public ResponseEntity<TeamMember> updateTeamMemberById(@PathVariable (value="memberId") int memberId ,  @RequestBody TeamMember teamMemberDetails) throws ResourceNotFoundException{
		return teamMemberService.updateTeamMemberById(memberId, teamMemberDetails); 
		
		
	}
	
	
	}
