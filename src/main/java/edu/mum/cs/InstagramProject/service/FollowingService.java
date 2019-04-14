package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.User;

public interface FollowingService {
	
	public User getFollowing(String FollowingId);

	public User saveFollowing(User Following);

	public User updateFollowing(User Following);

	public User deleteFollowing(String FollowingId);

	public List<User> getFollowingList(String userID);
	
}
