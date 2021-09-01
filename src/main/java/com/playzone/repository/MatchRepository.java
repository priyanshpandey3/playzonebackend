package com.playzone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.playzone.model.Match;
@Repository
public interface MatchRepository extends JpaRepository<Match,Integer> {

	Optional<Match> getMatchByStatus(String status);

	 List<Match> findAllByTrId(int trId);

	

	
	


}
