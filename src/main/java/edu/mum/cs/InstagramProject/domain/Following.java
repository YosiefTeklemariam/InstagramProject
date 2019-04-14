package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Following {
	
	@Id
	private String followingId;
	private User userFollowingTo;
	private List<User> userFollowings;
	
	public Following(User userFollowingTo) {
		super();
		this.userFollowingTo = userFollowingTo;
		this.userFollowings = new ArrayList<>();
	}
	
	public void addFollowing(User following) {
		userFollowings.add(following);
	}
	
	public String getId() {
		return followingId;
	}

	public void setId(String followingId) {
		this.followingId = followingId;
	}

	@Override
	public String toString() {
		return "Following [userFollowingTo=" + userFollowingTo + ", userFollowings=" + userFollowings.size() + "]";
	}

	public User getUser() {
		return userFollowingTo;
	}

	public void setUser(User user) {
		this.userFollowingTo = user;
	}

	public List<User> getFollowingUsers() {
		return userFollowings;
	}

	public void setFollowingUsers(List<User> userFollowings) {
		this.userFollowings = userFollowings;
	}

}
