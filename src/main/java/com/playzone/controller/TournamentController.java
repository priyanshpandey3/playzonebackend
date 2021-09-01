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

import com.playzone.model.Tournament;
import com.playzone.service.TournamentService;

@CrossOrigin(origins="*")
@RequestMapping("/api/tournaments")
@RestController
public class TournamentController {

	@Autowired
	TournamentService tournamentService;
	
	@PostMapping
	public Tournament addTournament(@RequestBody Tournament tournament) {

		return tournamentService.addTeamMember(tournament);
		
	}
	
	@GetMapping
	public List<Tournament> getAllTournaments(){
		return tournamentService.getAllTournaments(); 
	}
	
	@GetMapping("/{trId}")
	public ResponseEntity<Tournament> getByTrId(@PathVariable int trId) throws ResourceNotFoundException {
		Tournament tournament= tournamentService.getByTrId(trId);
		
		return ResponseEntity.ok().body(tournament);
	}
	
	@DeleteMapping("/{trId}")
	public Map<String,Boolean> deleteTrById(@PathVariable int trId) throws ResourceNotFoundException{
		
		
		return tournamentService.deleteTrById(trId); 
		
	}
	@PutMapping("/{trId}")
	public ResponseEntity<Tournament> updateTrById(@PathVariable (value="trId") int trId ,  @RequestBody Tournament tournamentDetails) throws ResourceNotFoundException{
		return tournamentService.updateTrById(trId, tournamentDetails); 
		
		
	}
	
	
	
}
