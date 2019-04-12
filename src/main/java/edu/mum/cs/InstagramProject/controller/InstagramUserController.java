package edu.mum.cs.InstagramProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.InstagramProject.domain.Post;
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

	@RequestMapping("/user/{id}")
	public User getUser(@PathVariable("id") String userId) {
		User user = userService.getUser(userId);
//		if(p==null) {
//			throw PostN;
//		}
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void removeUser(@PathVariable("id") String userId) {
		userService.getUser(userId);
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

//	@RequestMapping("/post/getall")
//	public List<User> getAllPost() {
//		return userService("@PathVariable(\"id\") String id");
//	}

}
