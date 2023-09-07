package com.demo.studyapirest.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.studyapirest.models.Badge;
import com.demo.studyapirest.models.Concept;
import com.demo.studyapirest.models.Idea;
import com.demo.studyapirest.models.Itinerary;
import com.demo.studyapirest.models.User;
import com.demo.studyapirest.services.StudyServiceImplementation;

@RestController
@RequestMapping("/api/v1")
public class StudyController {
	
	@Autowired
	StudyServiceImplementation studyServiceImplementation;
	
	@GetMapping("/users")
	public List<User> getUsers () {
		
		return studyServiceImplementation.getUsers();
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser (@RequestBody User user) {
		User newUser = studyServiceImplementation.saveUser(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getuser (@PathVariable String username) {
		User thisUser =  studyServiceImplementation.getUser(username);
		
		return ResponseEntity.ok(thisUser);
	}
	
	@PutMapping("/user/{username}")
	public ResponseEntity<User> updateUser (@PathVariable String username, @RequestBody User user) {
		User thisUser = studyServiceImplementation.getUser(username);
		thisUser.setUsername(user.getUsername());
		thisUser.setPassword(user.getPassword());
		thisUser.setEnabled(user.isEnabled());
		
		User updatedUser = studyServiceImplementation.saveUser(thisUser);
		
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{username}")
	public ResponseEntity<HashMap<String, Boolean>> deleteUser (@PathVariable String username) {
		
		this.studyServiceImplementation.deleteUser(username);
		
		HashMap<String, Boolean> userDeletedState =  new HashMap<String, Boolean>();
		userDeletedState.put("Deleted", true);
		return ResponseEntity.ok(userDeletedState);
	}
	
	@GetMapping("/itineraries")
	public List<Itinerary> getItineraries () {
		
		return studyServiceImplementation.getItineraries();
	}
	
	@PostMapping("/saveItinerary")
	public ResponseEntity<Itinerary> saveItinerary (@RequestBody Itinerary itinerary) {
		Itinerary newItinerary = studyServiceImplementation.saveItinerary(itinerary);
		
		return new ResponseEntity<>(newItinerary, HttpStatus.CREATED);
	}
	
	@GetMapping("/itinerary/{itineraryID}")
	public ResponseEntity<Itinerary> getItinerary (@PathVariable int itineraryID) {
		Itinerary thisItinerary =  studyServiceImplementation.getItinerary(itineraryID);
		
		return ResponseEntity.ok(thisItinerary);
	}
	
	@PutMapping("/itinerary/{itineraryID}")
	public ResponseEntity<Itinerary> updateItinerary (@PathVariable int itineraryID, @RequestBody Itinerary itinerary) {
		Itinerary thisItinerary = studyServiceImplementation.getItinerary(itineraryID);
		thisItinerary.setItineraryname(itinerary.getItineraryname());
		thisItinerary.setItinerarypoints(itinerary.getItinerarypoints());
		thisItinerary.setTargetDate(itinerary.getTargetDate());
		thisItinerary.setUser(itinerary.getUser());
		
		Itinerary updatedItinerary = studyServiceImplementation.saveItinerary(thisItinerary);
		
		return new ResponseEntity<>(updatedItinerary, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/itinerary/{itineraryID}")
	public ResponseEntity<HashMap<String, Boolean>> deleteItinerary (@PathVariable int itineraryID) {
		
		this.studyServiceImplementation.deleteItinerary(itineraryID);
		
		HashMap<String, Boolean> itineraryDeletedState =  new HashMap<String, Boolean>();
		itineraryDeletedState.put("Deleted", true);
		return ResponseEntity.ok(itineraryDeletedState);
	}
	
	@GetMapping("/concepts")
	public List<Concept> getConcepts () {
		
		return studyServiceImplementation.getConcepts();
	}
	
	@PostMapping("/saveConcept")
	public ResponseEntity<Concept> saveConcept (@RequestBody Concept concept) {
		Concept newConcept = studyServiceImplementation.saveConcept(concept);
		
		return new ResponseEntity<>(newConcept, HttpStatus.CREATED);
	}
	
	@GetMapping("/concept/{idconcept}")
	public ResponseEntity<Concept> getConcept (@PathVariable int idconcept) {
		Concept thisConcept =  studyServiceImplementation.getConcept(idconcept);
		
		return ResponseEntity.ok(thisConcept);
	}
	
	@PutMapping("/concept/{idconcept}")
	public ResponseEntity<Concept> updateConcept (@PathVariable int idconcept, @RequestBody Concept concept) {
		Concept thisConcept =  studyServiceImplementation.getConcept(idconcept);
		thisConcept.setTitleConcept(concept.getTitleConcept());
		thisConcept.setEffortEstimationConcept(concept.getEffortEstimationConcept());
		thisConcept.setNotesconcept(concept.getNotesconcept());
		thisConcept.setWhatConcept(concept.getWhatConcept());
		thisConcept.setHowConcept(concept.getHowConcept());
		thisConcept.setWhyConcept(concept.getWhyConcept());
		thisConcept.setCheckInCounterConcept(concept.getCheckInCounterConcept());
		thisConcept.setItinerary(concept.getItinerary());
		
		Concept updatedConcept = studyServiceImplementation.saveConcept(thisConcept);
		
		return new ResponseEntity<>(updatedConcept, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/concept/{idconcept}")
	public ResponseEntity<HashMap<String, Boolean>> deleteConcept (@PathVariable int idconcept) {
		
		this.studyServiceImplementation.deleteConcept(idconcept);
		
		HashMap<String, Boolean> conceptDeletedState =  new HashMap<String, Boolean>();
		conceptDeletedState.put("Deleted", true);
		return ResponseEntity.ok(conceptDeletedState);
	}
	
	@GetMapping("/ideas")
	public List<Idea> getIdeas () {
		
		return studyServiceImplementation.getIdeas();
	}
	
	@PostMapping("/saveIdeas")
	public ResponseEntity<Idea> saveIdeas (@RequestBody Idea idea) {
		Idea newIdeas = studyServiceImplementation.saveIdea(idea);
		
		return new ResponseEntity<>(newIdeas, HttpStatus.CREATED);
	}
	
	@GetMapping("/idea/{ideaID}")
	public ResponseEntity<Idea> getIdea (@PathVariable int ideaID) {
		Idea thisIdea =  studyServiceImplementation.getIdea(ideaID);
		
		return ResponseEntity.ok(thisIdea);
	}
	
	@PutMapping("/idea/{ideaID}")
	public ResponseEntity<Idea> updateIdea (@PathVariable int ideaID, @RequestBody Idea idea) {
		Idea thisIdea = studyServiceImplementation.getIdea(ideaID);
		thisIdea.setTitleIdea(idea.getTitleIdea());
		thisIdea.setDescriptionIdea(idea.getDescriptionIdea());
		thisIdea.setConcept(idea.getConcept());
		
		Idea updatedIdea = studyServiceImplementation.saveIdea(thisIdea);
		
		return new ResponseEntity<>(updatedIdea, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/idea/{ideaID}")
	public ResponseEntity<HashMap<String, Boolean>> deleteIdea (@PathVariable int ideaID) {
		
		this.studyServiceImplementation.deleteIdea(ideaID);
		
		HashMap<String, Boolean> ideaDeletedState =  new HashMap<String, Boolean>();
		ideaDeletedState.put("Deleted", true);
		return ResponseEntity.ok(ideaDeletedState);
	}
	
	
	
	@GetMapping("/badges")
	public List<Badge> getBadges () {
		
		return studyServiceImplementation.getBadges();
	}
	
	@PostMapping("/saveBadge")
	public ResponseEntity<Badge> saveBadge (@RequestBody Badge badge) {
		Badge newBadge = studyServiceImplementation.saveBadge(badge);
		
		return new ResponseEntity<>(newBadge, HttpStatus.CREATED);
	}
	
	@GetMapping("/badge/{badgeName}")
	public ResponseEntity<Badge> getBadge (@PathVariable String badgeName) {
		Badge thisBadge =  studyServiceImplementation.getBadge(badgeName);
		
		return ResponseEntity.ok(thisBadge);
	}
	
	@PutMapping("/badge/{badgeName}")
	public ResponseEntity<Badge> updateBadge (@PathVariable String badgeName, @RequestBody Badge badge) {
		Badge thisBadge = studyServiceImplementation.getBadge(badgeName);
		thisBadge.setBadgeName(badge.getBadgeName());
		thisBadge.setCoachMessage(badge.getCoachMessage());
		thisBadge.setIcon(badge.getIcon());
		
		Badge updatedBadge = studyServiceImplementation.saveBadge(thisBadge);
		
		return new ResponseEntity<>(updatedBadge, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/badge/{badgeName}")
	public ResponseEntity<HashMap<String, Boolean>> deleteBadge (@PathVariable String badgeName) {
		
		this.studyServiceImplementation.deleteBadge(badgeName);
		
		HashMap<String, Boolean> badgeDeletedState =  new HashMap<String, Boolean>();
		badgeDeletedState.put("Deleted", true);
		return ResponseEntity.ok(badgeDeletedState);
	}
	
}
