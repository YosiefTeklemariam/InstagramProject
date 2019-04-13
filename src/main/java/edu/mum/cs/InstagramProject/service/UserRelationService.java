package edu.mum.cs.InstagramProject.service;

import java.util.List;

import edu.mum.cs.InstagramProject.domain.UserRelation;


public interface UserRelationService {
	public UserRelation getUserRelation(String UserRealtionUserRelationId);

	public UserRelation saveUserRelation(UserRelation userRealtion);

	public UserRelation updateUserRelation(UserRelation userRealtion);

	public UserRelation deleteUserRelation(String userRealtionId);

	public List<UserRelation> getUserRelation();
}
