package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.Post;

public interface PostService {
	
	public Post getPost(String postId);

	public Post savePost(Post post);

	public Post updatePost(Post post);

	public Post deletePost(String postId);

	public List<Post> getPostList(String userID);
	
}
