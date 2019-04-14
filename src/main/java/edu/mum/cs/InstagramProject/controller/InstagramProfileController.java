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

import edu.mum.cs.InstagramProject.domain.Post;
import edu.mum.cs.InstagramProject.domain.Profile;
import edu.mum.cs.InstagramProject.service.ProfileService;

@RestController
public class InstagramProfileController {
	@Autowired
	ProfileService profileService;
	
	@RequestMapping("/homeprofile")
	public String home() {
		return "Welcome to Instagram-Profile";
	}
	@RequestMapping("/profile/get/{id}")
	public ResponseEntity<?> getPost(@PathVariable("id") String id) {
		Profile p = profileService.getProfile(id);
		if(p == null) {
			return new ResponseEntity<String>("Not valid id, Try again", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Profile>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/profile/remove/{id}")
	public void removeProfile(@PathVariable("id") String id) {
		profileService.deleteProfile(id);
	}

	@PostMapping("/profile/upload")
	public Profile saveProfile(@RequestBody Profile profile) {
		return profileService.saveProfile(profile);
	}

	@RequestMapping("/profile/getall")
	public List<Profile> getAllProfile() {
		return profileService.getProfileList();
	}

	
	

}

