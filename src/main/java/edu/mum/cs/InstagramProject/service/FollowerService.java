package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.User;

public interface FollowerService {
	
	public User getFollower(String userId);

	public User saveFollower(User follower);

	public User updateFollower(User follower);

	public User deleteFollower(String followerId);

	public List<User> getFollowerList(String followerID);

}
