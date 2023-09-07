package com.demo.studyapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.studyapirest.models.Idea;

@Repository
public interface StudyIdeaRepository extends JpaRepository<Idea, Integer> {

}


