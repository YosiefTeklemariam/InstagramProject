package edu.mum.cs.InstagramProject.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Comment {

	@Id
	private String Id;
	private String comment;
	private String ownerId;
	private LocalDateTime commentDate;
	private String postId;

	public String getId() {
		return Id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public void setId(String id) {
		Id = id;
	}

	

}
