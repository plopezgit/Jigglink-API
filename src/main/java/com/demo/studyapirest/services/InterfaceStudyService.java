package com.demo.studyapirest.services;

import java.util.List;

import com.demo.studyapirest.models.Concept;
import com.demo.studyapirest.models.Itinerary;
import com.demo.studyapirest.models.User;

public interface InterfaceStudyService {
	
	public List<User> getUsers ();
	public User saveUser (User user);
	public User getUser (String username);
	public void deleteUser (String username);
	
	public List<Itinerary> getItineraries ();
	public Itinerary saveItinerary (Itinerary itinerary);
	public Itinerary getItinerary (int itineraryID);
	public void deleteItinerary (int itineraryID);
	
	public List<Concept> getConcepts ();
	public Concept saveConcept (Concept concept);
	public Concept getConcept (int idconcept);
	public void deleteConcept (int idconcept);
	
}
