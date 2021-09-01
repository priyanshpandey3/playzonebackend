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
import com.playzone.model.Match;

import com.playzone.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

	
	@Autowired
	MatchRepository matchRepository ;
	

	@Override
	public Match creatematch(Match match) {
		
		return matchRepository.save(match) ;
	}


	@Override
	public List<Match> getAllMatches() {
		
		return matchRepository.findAll();
	}


	
	@Override
	public Match getMatchByMatchId(int matchId) throws ResourceNotFoundException{
		Match match=matchRepository.findById(matchId).orElseThrow(()->new ResourceNotFoundException("Team not found for this id" +"  "+matchId));
		return match;
	}


	
	@Override
	public Match getMatchByStatus(String status) throws ResourceNotFoundException {
		Match match=matchRepository.getMatchByStatus(status).orElseThrow(()->new ResourceNotFoundException("Team not found for this id" +"  "+status));
		return match;
	}


	
	

	

	@Override
	public ResponseEntity<Match>  updateMatchById(@PathVariable (value="matchId") int matchId ,  @RequestBody Match matchDetails) throws ResourceNotFoundException{
		
		Match match=matchRepository.findById(matchId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+matchId));
	

		match.setMatchName(matchDetails.getMatchName());
		match.setTeam1Code(matchDetails.getTeam1Code());
		match.setTeam2Code(matchDetails.getTeam2Code());
		match.setVenueId(matchDetails.getVenueId());
		match.setTrId(matchDetails.getTrId());
		match.setDateAndTime(matchDetails.getDateAndTime());
		match.setStatus(matchDetails.getStatus());
		match.setMatchInfo(matchDetails.getMatchInfo());
		
		
		
	final Match updatedMatch=matchRepository.save(match);
	
	
	return ResponseEntity.ok(updatedMatch) ;
	}


	@Override
	public Map<String, Boolean> deleteMatchById(int matchId) throws ResourceNotFoundException {
		
		Match match =matchRepository.findById(matchId).orElseThrow(()->new ResourceNotFoundException("Team member not found for this id" +"  "+matchId));
		
		matchRepository.delete(match);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return  response;
	}



	

	@Override
	public List<Match> getAllMatchesByTrId(int trId) throws ResourceNotFoundException {
		
		return matchRepository.findAllByTrId(trId);
	}

}
