package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Follower {
	
	@Id
	private String followedId;
	private User userFollowed;
	private List<User> userFollowers;
	
	public Follower(User userFollowed) {
		super();
		this.userFollowed = userFollowed;
		this.userFollowers = new ArrayList<>();
	}
	
	public void addFollower(User follower) {
		userFollowers.add(follower);
	}
	
	public String getFollowerId() {
		return followedId;
	}
	
	public void setFollowerId(String followedId) {
		this.followedId = followedId;
	}

	@Override
	public String toString() {
		return "Follower [user=" + userFollowed + ", userFollowers=" + userFollowers.size() + "]";
	}

	public User getUser() {
		return userFollowed;
	}

	public void setUser(User user) {
		this.userFollowed = user;
	}

	public List<User> getUserFollowers() {
		return userFollowers;
	}

	public void setUserFollowers(List<User> userFollowers) {
		this.userFollowers = userFollowers;
	}

}
