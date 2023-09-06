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

import com.demo.studyapirest.models.User;
import com.demo.studyapirest.services.UserServiceImplementation;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@GetMapping("/users")
	public List<User> getUsers () {
		
		return userServiceImplementation.getUsers();
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser (@RequestBody User user) {
		User newUser = userServiceImplementation.save(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getuser (@PathVariable String username) {
		User thisUser =  userServiceImplementation.getUser(username);
		
		return ResponseEntity.ok(thisUser);
	}
	
	@PutMapping("/user/{username}")
	public ResponseEntity<User> updateUser (@PathVariable String username, @RequestBody User user) {
		User thisUser = userServiceImplementation.getUser(username);
		thisUser.setUsername(user.getUsername());
		thisUser.setPassword(user.getPassword());
		thisUser.setEnabled(user.isEnabled());
		
		User updatedUser = userServiceImplementation.save(thisUser);
		
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{username}")
	public ResponseEntity<HashMap<String, Boolean>> deleteUser (@PathVariable String username) {
		
		this.userServiceImplementation.deleteUser(username);
		
		HashMap<String, Boolean> userDeletedState =  new HashMap<String, Boolean>();
		userDeletedState.put("Deleted", true);
		return ResponseEntity.ok(userDeletedState);
	}
}
