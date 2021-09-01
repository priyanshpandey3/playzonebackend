
package com.playzone.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.playzone.exception.ResourceNotFoundException;

import com.playzone.model.TeamMember;
import com.playzone.repository.TeamMemberRepository; 



@Service
public class TeamMemberServiceImpl implements TeamMemberService{


	@Autowired 
	TeamMemberRepository teamMemberRepository;
	
	
	
	@Override
	public TeamMember addTeamMember(TeamMember teamMmeber) {

		return teamMemberRepository.save(teamMmeber); 
	}




	@Override public List<TeamMember> getAllTeamMembers(int teamId) {

		return teamMemberRepository.findAllByteamId(teamId); 
	}

	@Override public List<TeamMember> getAllTeamMembers() {

		return teamMemberRepository.findAll(); 
	}


	@Override
	public Map<String,Boolean> deleteTeamMemberById(int memberId) throws ResourceNotFoundException {
		System.out.println(memberId);
		TeamMember teamMember =teamMemberRepository.findById(memberId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+memberId));
		
		teamMemberRepository.delete(teamMember);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return  response;
	}




	
	@Override
	public ResponseEntity<TeamMember> updateTeamMemberById(@PathVariable (value="memberId") int memberId ,  @RequestBody TeamMember teamMemberDetails) throws ResourceNotFoundException{
		
	TeamMember teamMember =teamMemberRepository.findById(memberId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+memberId));
	

	teamMember.setMemberName(teamMemberDetails.getMemberName());
	final TeamMember updatedTeamMember=teamMemberRepository.save(teamMember);
	
	
	return ResponseEntity.ok(updatedTeamMember) ;
	}




	


	
	}



