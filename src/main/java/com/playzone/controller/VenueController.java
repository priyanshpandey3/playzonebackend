package com.playzone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playzone.exception.ResourceNotFoundException;
import com.playzone.model.Match;
import com.playzone.model.Venue;
import com.playzone.service.VenueService;
@CrossOrigin(origins = "*")
@RequestMapping("/api/venues")
@RestController
public class VenueController {

	@Autowired
	VenueService venueService;
	
	@PostMapping 
	public Venue createVenue( @RequestBody Venue venue) {
		
		return venueService.createVenue(venue);

   }
	
	@GetMapping
	public List<Venue> getAllVenues(){
		return venueService.getAllVenues(); 
	}
	
	
	@GetMapping("/{venueId}")
	public ResponseEntity<Venue> getVenueByVenueId(@PathVariable int venueId) throws ResourceNotFoundException {
		Venue venue= venueService.getVenueByVenueId(venueId);
		return ResponseEntity.ok().body(venue);
	
	}
	
	
	
	@PutMapping("/{venueId}")
	public ResponseEntity<Venue> updateVenueById(@PathVariable (value="venueId") int venueId ,  Venue venueDetails) throws ResourceNotFoundException{
		return venueService.updateVenueById(venueId , venueDetails); 
		
		
	}
	
	
	
	@DeleteMapping("/{venueId}")
	public Map<String,Boolean> deleteVenueById(@PathVariable int venueId) throws ResourceNotFoundException{
		
		
		return venueService.deleteVenueById(venueId); 
		
	}
	
	
	
	
}
