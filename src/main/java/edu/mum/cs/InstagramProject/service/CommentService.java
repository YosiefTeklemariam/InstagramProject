package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.Comment;

public interface CommentService {
	
	public Comment getComment(String commentId);

	public Comment saveComment(Comment comment);

	public Comment updateComment(Comment comment);

	public Comment deleteComment(String commentId);

	public List<Comment> getCommentList();
	
}
