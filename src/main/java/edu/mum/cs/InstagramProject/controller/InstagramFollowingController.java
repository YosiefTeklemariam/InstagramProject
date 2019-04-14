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

import edu.mum.cs.InstagramProject.domain.Following;
import edu.mum.cs.InstagramProject.service.FollowingService;

@RestController
@RequestMapping("/")

public class InstagramFollowingController {
	@Autowired
	FollowingService followingService;

	@RequestMapping("/Following")
	public String following() {
		return "Welcome to Instagram-Following";
	}

	@RequestMapping("/following/get/{id}")
	public ResponseEntity<?> getFollowing(@PathVariable("id") String id) {
		Following following = followingService.getFollowing(id);
		if (following == null) {
			return new ResponseEntity<String>("Not valid id, Try again", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Following>(following, HttpStatus.OK);
	}

	@DeleteMapping("/following/remove/{id}")
	public void removeFollowing(@PathVariable("id") String id) {
		followingService.deleteFollowing(id);
	}

	@PostMapping("/following/upload")
	public Following saveFollowing(@RequestBody Following following) {
		return followingService.saveFollowing(following);
	}

	@RequestMapping("/following/getall")
	public List<Following> getAllFollowing() {
		return followingService.getFollowingList("@PathVariable(\"id\") String id");
	}

}
