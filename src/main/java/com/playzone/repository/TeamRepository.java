package com.playzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playzone.model.Team;
//import com.playzone.model.TeamMember;

public interface TeamRepository extends JpaRepository<Team, Integer>{

	

}
