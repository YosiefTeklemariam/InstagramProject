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

import edu.mum.cs.InstagramProject.domain.Follower;
import edu.mum.cs.InstagramProject.service.FollowerService;

public class InstagramFollowerController {
	@Autowired
	FollowerService followerService;

	@RequestMapping("/follower")
	public String follower() {
		return "Welcome to Instagram-Follower";
	}

	@RequestMapping("/follower/get/{id}")
	public ResponseEntity<?> getFollower(@PathVariable("id") String id) {
		Follower follower = followerService.getFollower(id);
		if (follower == null) {
			return new ResponseEntity<String>("Not valid id, Try again", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Follower>(follower, HttpStatus.OK);
	}

	@DeleteMapping("/follower/remove/{id}")
	public void removeFollower(@PathVariable("id") String id) {
		followerService.deleteFollower(id);
	}

	@PostMapping("/follower/upload")
	public Follower saveFollower(@RequestBody Follower follower) {
		return followerService.saveFollower(follower);
	}

	@RequestMapping("/follower/getall")
	public List<Follower> getAllFollower() {
		return followerService.getFollowerList("@PathVariable(\"id\") String id");
	}

}
