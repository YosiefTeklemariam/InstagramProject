package edu.mum.cs.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.InstagramProject.domain.Post;
import edu.mum.cs.InstagramProject.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	public PostServiceImpl() {

	}

	@Override
	public Post getPost(String postId) {
		Post post = postRepository.findById(postId).orElse(null);
		return post;
	}

	@Override
	public Post savePost(Post post) {
		postRepository.save(post);
		return post;
	}

	@Override
	public Post updatePost(Post post) {
		Post oldPost = getPost(post.getId());
		if (!oldPost.equals(null)) {
			postRepository.delete(oldPost);
			postRepository.save(post);
			return post;
		} else {
			return null;
		}
	}

	@Override
	public Post deletePost(String postId) {
		Post oldPost = getPost(postId);
		if (oldPost != null) {
			postRepository.delete(oldPost);
			return oldPost;
		} else {
			return null;
		}
	}

	@Override
	public List<Post> getPostList(String userId) {
		return postRepository.findAll();
	}

}
