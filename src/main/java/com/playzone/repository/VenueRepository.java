package com.playzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playzone.model.Venue;

public interface VenueRepository extends JpaRepository<Venue,Integer> {

}
