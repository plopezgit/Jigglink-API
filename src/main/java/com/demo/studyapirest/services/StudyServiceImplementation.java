package com.demo.studyapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studyapirest.models.Concept;
import com.demo.studyapirest.models.Itinerary;
import com.demo.studyapirest.models.User;
import com.demo.studyapirest.repository.StudyConceptRepository;
import com.demo.studyapirest.repository.StudyItineraryRepository;
import com.demo.studyapirest.repository.StudyUserRepository;

@Service
public class StudyServiceImplementation implements InterfaceStudyService {
	
	@Autowired
	StudyUserRepository userRepository;
	@Autowired
	StudyItineraryRepository itineraryRepository;
	@Autowired
	StudyConceptRepository conceptRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(String username) {
		return userRepository.findById(username).orElse(null);
	}

	@Override
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}

	@Override
	public List<Itinerary> getItineraries() {
		return itineraryRepository.findAll();
	}

	@Override
	public Itinerary saveItinerary(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}

	@Override
	public Itinerary getItinerary(int itineraryID) {
		return itineraryRepository.findById(itineraryID).orElse(null);
	}

	@Override
	public void deleteItinerary(int itineraryID) {
		itineraryRepository.deleteById(itineraryID);
		
	}

	@Override
	public List<Concept> getConcepts() {
		return conceptRepository.findAll();
	}

	@Override
	public Concept saveConcept(Concept concept) {
		return conceptRepository.save(concept);
	}

	@Override
	public Concept getConcept(int idconcept) {
		return conceptRepository.findById(idconcept).orElse(null);
	}

	@Override
	public void deleteConcept(int idconcept) {
		conceptRepository.deleteById(idconcept);
		
	}

}
