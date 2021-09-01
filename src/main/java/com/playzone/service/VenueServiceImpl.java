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
import com.playzone.model.Venue;
import com.playzone.repository.VenueRepository;

@Service
public class VenueServiceImpl implements VenueService {

	
	
	@Autowired
	VenueRepository venueRepository;
	@Override
	public Venue createVenue(Venue venue) {
	
		return venueRepository.save(venue);
	}
	
	
	@Override
	public List<Venue> getAllVenues() {
		
		return venueRepository.findAll();
	}

	
	@Override
	public ResponseEntity<Venue> updateVenueById(@PathVariable (value="venueId") int venueId ,  @RequestBody Venue venueDetails) throws ResourceNotFoundException{
		
	Venue venue=venueRepository.findById(venueId).orElseThrow(()->new ResourceNotFoundException("venue not found for this id" +"  "+venueId));
	

	venue.setVenueName(venueDetails.getVenueName());
	venue.setVenueAddress(venueDetails.getVenueAddress());
			
	final Venue updatedVenue=venueRepository.save(venue);
	
	return ResponseEntity.ok(updatedVenue) ;
	}


	@Override
	public Map<String, Boolean> deleteVenueById(int venueId) throws ResourceNotFoundException {
		
		Venue venue =venueRepository.findById(venueId).orElseThrow(()->new ResourceNotFoundException("venue not found for this id" +"  "+venueId));
		
		venueRepository.delete(venue);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return  response;
	}


	

		@Override
		public Venue getVenueByVenueId(int venueId) throws ResourceNotFoundException{
			Venue venue=venueRepository.findById(venueId).orElseThrow(()->new ResourceNotFoundException("Venue not found for this id" +"  "+venueId));
			return venue;
		}

		
	}


