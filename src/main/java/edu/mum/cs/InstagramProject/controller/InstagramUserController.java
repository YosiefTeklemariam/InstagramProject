package edu.mum.cs.InstagramProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.InstagramProject.domain.User;
import edu.mum.cs.InstagramProject.service.UserService;

@RestController
public class InstagramUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/userhome")
	public String userHome() {
		return "Welcome to Instagram User";
	}

	@RequestMapping("/user/get/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") String userId) {
		User user = userService.getUser(userId);
		if(user == null) {
			return new ResponseEntity<String>("Not valid id, Try again", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/remove/{id}")
	public void removeUser(@PathVariable("id") String userId) {
		userService.getUser(userId);
	}

	@PostMapping("/user/create")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@RequestMapping("/user/getall")
	public List<User> getAllUsers() {
		return userService.getUserList();
	}

}
