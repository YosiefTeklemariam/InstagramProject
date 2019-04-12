package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

public class Follower extends Profile {
	
	private String id;
	private User user;
	private List<User> userFollowers;
	
	public Follower() {
		super();
		this.userFollowers = new ArrayList<>();
	}

	public Follower(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Follower [user=" + user + ", userFollowers=" + userFollowers.size() + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserFollowers() {
		return userFollowers;
	}

	public void setUserFollowers(List<User> userFollowers) {
		this.userFollowers = userFollowers;
	}

}
