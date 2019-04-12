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
import edu.mum.cs.InstagramProject.service.PostService;

@RestController
@RequestMapping("/")
public class InstagramPostController {

	@Autowired
	PostService postService;

	@RequestMapping("/home")
	public String home() {
		return "Welcome to Instagram";
	}

	@RequestMapping("/post/{id}")
	public ResponseEntity<?> getPost(@PathVariable("id") String id) {
		Post p = postService.getPost(id);
		if(p == null) {
			return new ResponseEntity<String>("Not valid id, Try again", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/post/{id}")
	public void removePost(@PathVariable("id") String id) {
		postService.deletePost(id);
	}

	@PostMapping("/post")
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	@RequestMapping("/post/getall")
	public List<Post> getAllPost() {
		return postService.getPostList("@PathVariable(\"id\") String id");
	}

}
