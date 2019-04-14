package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String userId;
	private Profile profile;
	private Follower followers;
	private Following followings;
	private List<Post> postsList;
	
	public User(Profile profile, Follower followers, Following followings) {
		super();
		this.profile = profile;
		this.followers = new Follower(this);
		this.followings = new Following(this);
		this.postsList = new ArrayList<>();
	}

	public String getUserId() {
		return userId;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<User> getFollowers() {
		return followers.getUserFollowers();
	}

	public void setFollowers(Follower followers) {
		this.followers = followers;
	}

	public List<User> getFollowings() {
		return followings.getFollowingUsers();
	}

	public void setFollowings(Following followings) {
		this.followings = followings;
	}

	public List<Post> getPostsList() {
		return postsList;
	}

	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", profile=" + profile 
				+ ", followers=" + followers.getUserFollowers().size() 
				+ ", followings=" + followings.getFollowingUsers().size() 
				+ ", postsList=" + postsList + "]";
	}
	
}
