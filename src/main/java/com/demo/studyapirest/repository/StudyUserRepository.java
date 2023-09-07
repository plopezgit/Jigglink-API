package com.demo.studyapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.studyapirest.models.User;

@Repository
public interface StudyUserRepository extends JpaRepository<User, String> {

}


