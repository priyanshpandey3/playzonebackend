package com.playzone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.playzone.model.Match;
import com.playzone.model.Score;
@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer> {

	Optional<Score> getScoreByStatus(String status);

	 List<Score> findAllByTrId(int trId);

	

	
	


}
