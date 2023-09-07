package com.demo.studyapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.studyapirest.models.Itinerary;

@Repository
public interface StudyItineraryRepository extends JpaRepository<Itinerary, Integer> {

}


