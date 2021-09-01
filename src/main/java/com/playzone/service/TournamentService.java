package com.playzone.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Tournament;

public interface TournamentService {

	Tournament addTeamMember(Tournament tournament);

	List<Tournament> getAllTournaments();

	Tournament getByTrId(int trId) throws ResourceNotFoundException;

	Map<String, Boolean> deleteTrById(int trId) throws ResourceNotFoundException;

	ResponseEntity<Tournament> updateTrById(int trId, Tournament tournamentDetails) throws ResourceNotFoundException;

}
