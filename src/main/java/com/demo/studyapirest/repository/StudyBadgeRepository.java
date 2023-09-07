package com.demo.studyapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.studyapirest.models.Badge;

@Repository
public interface StudyBadgeRepository extends JpaRepository<Badge, String> {

}


