package com.demo.studyapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.studyapirest.models.Concept;

@Repository
public interface StudyConceptRepository extends JpaRepository<Concept, Integer> {

}


