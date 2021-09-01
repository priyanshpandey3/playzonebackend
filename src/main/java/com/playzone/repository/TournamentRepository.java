package com.playzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playzone.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament,Integer>{

}
