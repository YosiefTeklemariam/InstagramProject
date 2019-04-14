package edu.mum.cs.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs.InstagramProject.domain.Comment;
import edu.mum.cs.InstagramProject.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	public CommentServiceImpl() {
		super();
	}

	@Override
	public Comment getComment(String commentId) {
		Comment comment = commentRepository.findById(commentId).orElse(null);
		return comment;
	}

	@Override
	public Comment saveComment(Comment comment) {
		commentRepository.save(comment);
		return comment;
	}

	@Override
	public Comment updateComment(Comment comment) {
		Comment oldComment = getComment(comment.getId());
		if (!oldComment.equals(null)) {
			commentRepository.delete(oldComment);
			commentRepository.save(comment);
			return comment;
		} else {
			return null;
		}
	}

	@Override
	public Comment deleteComment(String userId) {
		Comment oldComment = getComment(userId);
		if (oldComment != null) {
			commentRepository.delete(oldComment);
			return oldComment;
		} else {
			return null;
		}
	}

	@Override
	public List<Comment> getCommentList() {
		return commentRepository.findAll();
	}

}
