
package com.playzone.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Match;

public interface MatchService{
	public Match creatematch(Match match);

	public List<Match> getAllMatches();

	public	Match getMatchByMatchId(int matchId) throws ResourceNotFoundException;

	public Match getMatchByStatus(String status) throws ResourceNotFoundException;

	

	public ResponseEntity<Match> updateMatchById(int matchId, Match matchDetails) throws ResourceNotFoundException ;

	public Map<String, Boolean> deleteMatchById(int matchId) throws ResourceNotFoundException;

	

	public List<Match> getAllMatchesByTrId(int trId) throws ResourceNotFoundException;


}