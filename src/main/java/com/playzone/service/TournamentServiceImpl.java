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

import com.playzone.model.Tournament;
import com.playzone.repository.TournamentRepository;

@Service
public class TournamentServiceImpl implements TournamentService {

	
	
	@Autowired
	 TournamentRepository  tournamentRepository;
	
	
	
	@Override
	public Tournament addTeamMember(Tournament tournament) {
	
		return tournamentRepository.save(tournament);
	}



	@Override
	public List<Tournament> getAllTournaments() {
		
		return tournamentRepository.findAll();
	}



	@Override
	public Tournament getByTrId(int trId) throws ResourceNotFoundException{
		Tournament tournament=tournamentRepository.findById(trId).orElseThrow(()->new ResourceNotFoundException("Team not found for this id" +"  "+trId));
		return tournament;
	}



	
		@Override
		public Map<String,Boolean> deleteTrById(int trId) throws ResourceNotFoundException {
		
			Tournament tournament =tournamentRepository.findById(trId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+trId));
			
			tournamentRepository.delete(tournament);
			
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return  response;
		}



		
		@Override
		public ResponseEntity<Tournament> updateTrById(@PathVariable (value="trId") int trId ,  @RequestBody Tournament tournamentDetails) throws ResourceNotFoundException{
			
			Tournament tournament =tournamentRepository.findById(trId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+trId));
		

			
			
			tournament.setTrName(tournamentDetails.getTrName());
			tournament.setStartDate(tournamentDetails.getStartDate());
			tournament.setEndDate(tournamentDetails.getEndDate());
			tournament.setApplnStartDate(tournamentDetails.getApplnStartDate());
			tournament.setApplnEndDate(tournamentDetails.getApplnEndDate());
			tournament.setStatus(tournamentDetails.getStatus());
			tournament.setInfo(tournamentDetails.getInfo());
			
			
			
			
		final Tournament updatedTournament=tournamentRepository.save(tournament);
		
		
		return ResponseEntity.ok(updatedTournament) ;
		}
	
	
	
}
