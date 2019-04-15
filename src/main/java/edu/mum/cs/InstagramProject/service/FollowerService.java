package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.User;
import edu.mum.cs.InstagramProject.dto.FollowerDTO;

public interface FollowerService {
	
	public User getFollower(String userId);

	public User saveFollower(User follower);

	public User updateFollower(User follower);

	public User deleteFollower(String followerId);

	public List<User> getFollowerList(String followerID);
	
	public User addFollower(FollowerDTO follower);

}
