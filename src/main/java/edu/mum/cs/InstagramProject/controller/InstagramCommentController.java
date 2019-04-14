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

import edu.mum.cs.InstagramProject.domain.Comment;
import edu.mum.cs.InstagramProject.service.CommentService;

@RestController
public class InstagramCommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping("/commenthome")
	public String commentHome() {
		return "Welcome to Instagram Comment";
	}

	@RequestMapping("/comment/get/{id}")
	public ResponseEntity<?> getComment(@PathVariable("id") String commentId) {
		Comment comment = commentService.getComment(commentId);
		if(comment == null) {
			return new ResponseEntity<String>("Not valid id, Try again", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/remove/{id}")
	public void removeComment(@PathVariable("id") String commentId) {
		commentService.getComment(commentId);
	}

	@PostMapping("/comment/create")
	public Comment saveComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}

	@RequestMapping("/comment/getall")
	public List<Comment> getAllComments() {
		return commentService.getCommentList();
	}

}
