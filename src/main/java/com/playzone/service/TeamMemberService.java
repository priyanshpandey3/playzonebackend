
package com.playzone.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.playzone.exception.ResourceNotFoundException; 
import com.playzone.model.TeamMember;


public interface TeamMemberService {
	
	public List<TeamMember> getAllTeamMembers();

	public TeamMember addTeamMember(TeamMember teamMember);

	public List<TeamMember> getAllTeamMembers(int teamId);
	
	public Map<String, Boolean> deleteTeamMemberById(int memberId) throws ResourceNotFoundException;

	//public ResponseEntity<TeamMember> updateTeamMemberById(int memberId) throws ResourceNotFoundException;

	ResponseEntity<TeamMember> updateTeamMemberById(int memberId, TeamMember teamMemberDetails)
			throws ResourceNotFoundException;

	

	

	

}
