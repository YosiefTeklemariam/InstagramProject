package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

public class Following extends Profile {
	
	private String id;
	private User user;
	private List<User> followingUsers;
	
	public Following() {
		super();
		this.followingUsers = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Following [user=" + user + ", followingUsers=" + followingUsers.size() + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getFollowingUsers() {
		return followingUsers;
	}

	public void setFollowingUsers(List<User> followingUsers) {
		this.followingUsers = followingUsers;
	}

}
