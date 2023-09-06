package com.demo.studyapirest.services;

import java.util.List;

import com.demo.studyapirest.models.User;

public interface InterfaceStudyService {
	
	public List<User> getUsers ();
	public User save (User user);
	public User getUser (String username);
	public void deleteUser (String username);
	
}
