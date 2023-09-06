package com.demo.studyapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studyapirest.models.User;
import com.demo.studyapirest.repository.StudyRepository;

@Service
public class UserServiceImplementation implements InterfaceStudyService {
	
	@Autowired
	StudyRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
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

}
