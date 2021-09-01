
package com.playzone.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.playzone.model.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer>{

	List<TeamMember> findAllByteamId(int teamId);

	Object findByteamId(int teamId);

	
	

}


