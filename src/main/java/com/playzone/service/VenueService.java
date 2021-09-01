package com.playzone.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Venue;

public interface VenueService {

	public Venue createVenue(Venue venue);

	public List<Venue> getAllVenues();

	public ResponseEntity<Venue> updateVenueById(int venueId, Venue venueDetails) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteVenueById(int venueId) throws ResourceNotFoundException;

	

	public Venue getVenueByVenueId(int venueId) throws ResourceNotFoundException;

	

	

}
