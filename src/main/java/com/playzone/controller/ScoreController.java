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
import com.playzone.model.Match;
import com.playzone.model.Score;
import com.playzone.service.MatchService;
import com.playzone.service.ScoreService;

@CrossOrigin(origins="*")
@RequestMapping("/api/score")
@RestController
public class ScoreController {
	
	
	@Autowired
	ScoreService scoreService;
	
	@Autowired
	MatchService matchService;
	
	
	@PostMapping
	public Score createscore( @RequestBody Score score) {
		
		return scoreService.addScore(score);

   }
	
	
	  @GetMapping public List<Score> getAllScore(){ return
			  scoreService.getAllScore(); }
	 
	
	
	@GetMapping("/{matchId}")
	public ResponseEntity<Match> getMatchByMatchId(@PathVariable int matchId) throws ResourceNotFoundException {
		Match match= matchService.getMatchByMatchId(matchId);
		return ResponseEntity.ok().body(match);
	
	}
	@GetMapping("/status/{status}")
	public ResponseEntity<Match> getMatchByStatus(@PathVariable String status) throws ResourceNotFoundException {
		Match match= matchService.getMatchByStatus(status);
		return ResponseEntity.ok().body(match);
	
	}
	
	
	  @GetMapping("/trid/{trId}") 
	  public List<Match> getAllMatchesByTrId(@PathVariable int trId) throws ResourceNotFoundException{
	  return matchService.getAllMatchesByTrId(trId);
	  }
	 
	
	@PutMapping("/{matchId}")
	public ResponseEntity<Match> updateMatchById(@PathVariable (value="matchId") int matchId ,  @RequestBody Match matchDetails) throws ResourceNotFoundException{
		return matchService.updateMatchById(matchId, matchDetails); 
		
		
	}
	@DeleteMapping("/{matchId}")
	public Map<String,Boolean> deleteMatchById(@PathVariable int matchId) throws ResourceNotFoundException{

		return matchService.deleteMatchById(matchId); 
		
	}
	
	
	
	
}