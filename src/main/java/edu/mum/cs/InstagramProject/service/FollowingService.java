package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.Following;

public interface FollowingService {
	public Following getFollowing(String FollowingId);

	public Following saveFollowing(Following Following);

	public Following updateFollowing(Following Following);

	public Following deleteFollowing(String FollowingId);

	public List<Following> getFollowingList(String userID);
	

}
