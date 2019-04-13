package edu.mum.cs.InstagramProject.domain;

import java.util.ArrayList;
import java.util.List;

public class UserRelation extends Profile {
	private String UserRelationId;
	private List<User> followersList;
	private List<User> followingsList;

	public UserRelation() {
		super();
		followersList = new ArrayList<>();
		followingsList = new ArrayList<>();
	}
	
	public String getUserRelationId() {
		return UserRelationId;
	}

	public void setUserRelationId(String userRelationId) {
		UserRelationId = userRelationId;
	}
	
	public void addUserRelation(User user) {
		followersList.add(user);
		followingsList.add(user);
	}
	
	public void removeUserRelation(User user) {
		followersList.remove(user);
		followingsList.remove(user);
	}

	public List<User> getFollowersList() {
		return followersList;
	}

	public void setFollowersList(List<User> followersList) {
		this.followersList = followersList;
	}

	public List<User> getFollowingsList() {
		return followingsList;
	}

	public void setFollowingsList(List<User> followingsList) {
		this.followingsList = followingsList;
	}

	@Override
	public String toString() {
		return "UserRelation [followersList=" + followersList.size() + ", followingsList=" + followingsList.size() + "]";
	}

}
