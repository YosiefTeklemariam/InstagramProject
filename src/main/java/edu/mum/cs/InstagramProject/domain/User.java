package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends Profile {
	
	@Id
	private String userId;
	private List<Post> postsList;
	private List<UserRelation> userRelationsList;
	private List<Follower> followersList;
	private List<Following> followingsList;
	
	public User() {
		super();
		postsList = new ArrayList<>();
		userRelationsList = new ArrayList<>();
		followersList = new ArrayList<>();
		followingsList = new ArrayList<>();
	}
	
	public void addUserRelation(UserRelation userRelation) {
		userRelationsList.add(userRelation);
	}
	
	public void addFollower(Follower follower) {
		followersList.add(follower);
	}
	
	public void addFollowing(Following following) {
		followingsList.add(following);
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Post> getPostsList() {
		return postsList;
	}

	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}

	public List<UserRelation> getFriendsList() {
		return userRelationsList;
	}

	public void setFriendsList(List<UserRelation> friendsList) {
		this.userRelationsList = friendsList;
	}

	public List<Follower> getFollowerList() {
		return followersList;
	}

	public void setFollowerList(List<Follower> followerList) {
		this.followersList = followerList;
	}

	public List<Following> getFollowingList() {
		return followingsList;
	}

	public void setFollowingList(List<Following> followingList) {
		this.followingsList = followingList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", postsList=" + postsList.size() + ", friendsList=" + userRelationsList.size()
				+ ", followerList=" + followersList.size() + ", followingList=" + followingsList.size() + "]";
	}
	
}
